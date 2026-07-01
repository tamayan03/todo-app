package com.example.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.ToDo;
import com.example.webapp.form.ToDoForm;
import com.example.webapp.helper.ToDoHelper;
import com.example.webapp.service.ToDoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    /** DI */
    private final ToDoService toDoService;
    
    /** ロガー */
    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);
    
    @GetMapping("/search")
    public String search(
            String keyword,
            String category,
            Model model) {

        logger.info("タイトル検索開始 keyword={}", keyword);

        model.addAttribute(
                "todos",
                toDoService.search(keyword, category));

        model.addAttribute(
                "keyword",
                keyword);

        model.addAttribute(
                "category",
                category);

        logger.info("タイトル検索終了");

        return "todo/list";
    }

    /**
     * 一覧表示
     */
    @GetMapping
    public String list(String sort,Model model) {
    	
    	logger.info("ToDo一覧表示開始");

        model.addAttribute(
            "todos",
            toDoService.findAllToDo(sort));
        
        model.addAttribute(
                "sort",
                sort);

        int completedCount =
                toDoService.getCompletedCount();

        model.addAttribute(
                "completedCount",
                completedCount);

        model.addAttribute(
                "aquarium",
                createAquarium(completedCount));
        
        logger.info("ToDo一覧表示終了");

        return "todo/list";
    }

    /**
     * 詳細表示
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model,
            RedirectAttributes attributes) {
    	
    	logger.info("ToDo詳細表示 id={}", id);
    	
        ToDo todo =toDoService.findByIdToDo(id);

        if (todo != null) {
            model.addAttribute("todo", todo);
            logger.info("ToDo詳細表示完了 id={}", id);
            return "todo/detail";
        } else {
            attributes.addFlashAttribute(
                    "errorMessage",
                    "対象データがありません");           
            logger.warn("対象データなし id={}", id);
            return "redirect:/todos";
        }
    }

    /**
     * 新規登録画面表示
     */
    @GetMapping("/add")
    public String add(Model model) {
    	
    	logger.info("新規登録画面表示");

        ToDoForm form = new ToDoForm();
        form.setIsNew(true);
        
        model.addAttribute("todoForm", form);

        return "todo/form";
    }

    /**
     * 更新画面表示
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id,
            Model model,
            RedirectAttributes attributes) {
    	
    	logger.info("更新画面表示 id={}", id);

        ToDo todo = toDoService.findByIdToDo(id);

        if (todo == null) {
            attributes.addFlashAttribute(
                    "errorMessage",
                    "対象データがありません");
            
            logger.warn("更新対象なし id={}", id);
            
            return "redirect:/todos";
        }

        model.addAttribute(
                "todoForm",
                ToDoHelper.convertToDoForm(todo));
        
        logger.info("更新画面表示完了");

        return "todo/form";
    }

    /**
     * 登録・更新処理
     */
    @PostMapping("/save")
    public String save(
            @Validated @ModelAttribute("todoForm") ToDoForm todoForm,
            BindingResult result,
            Model model,
            RedirectAttributes attributes) {
    	
    	logger.info("保存処理開始 isNew={}", todoForm.getIsNew());

        if (result.hasErrors()) {
            model.addAttribute("todoForm", todoForm);
            return "todo/form";
        }
        
     // 締切日が過去日かチェック
        if (todoForm.getDueDate() != null
                && todoForm.getDueDate().isBefore(java.time.LocalDate.now())) {

            result.rejectValue(
                    "dueDate",
                    "pastDate",
                    "締切日は今日以降の日付を入力してください");
            
            model.addAttribute("todoForm", todoForm);

            return "todo/form";
        }
        
     // タイトル重複チェック
        ToDo duplicate = toDoService.findDuplicateTodo(todoForm.getTodo());

        if (duplicate != null && todoForm.getIsNew()) {

            result.rejectValue(
                    "todo",
                    "duplicate",
                    "同じタイトルの未完了タスクが既に存在します");

            return "todo/form";
        }

        ToDo todo = ToDoHelper.convertToDo(todoForm);

        if (todoForm.getIsNew()) {
            toDoService.insertToDo(todo);
            attributes.addFlashAttribute(
                    "message", "登録しました");
            logger.info("ToDo新規登録 title={}", todo.getTodo());
        } else {
            toDoService.updateToDo(todo);
            attributes.addFlashAttribute(
                    "message", "更新しました");
            logger.info("更新 id={}", todo.getId());
        }
        
        logger.info("保存処理終了");

        return "redirect:/todos";
    }
    
    @PostMapping("/delete/{id}")
    public String delete(
            @PathVariable Integer id,
            RedirectAttributes attributes) {
    	
    	logger.info("削除 id={}", id);

        toDoService.deleteToDo(id);

        attributes.addFlashAttribute(
                "message",
                "削除しました");
        
        logger.info("削除完了 id={}", id);

        return "redirect:/todos";
    }
    
    @PostMapping("/complete/{id}")
    public String complete(
            @PathVariable Integer id,
            RedirectAttributes attributes) {
    	
    	logger.info("完了処理 id={}", id);

        toDoService.complete(id);

        attributes.addFlashAttribute(
                "message",
                "完了しました");
        
        logger.info("完了処理終了 id={}", id);

        return "redirect:/todos";
    }
        
        private String createAquarium(int count){

            String aquarium = "🫧";

            if(count >= 1){
                aquarium += " 🐟";
            }

            if(count >= 5){
                aquarium += " 🐠";
            }

            if(count >= 10){
                aquarium += " 🦀";
            }

            if(count >= 20){
                aquarium += " 🦈";
            }

            if(count >= 30){
                aquarium += " 🐢";
            }

            if(count >= 50){
                aquarium += " 🐳";
            }

            return aquarium;
        }

    }