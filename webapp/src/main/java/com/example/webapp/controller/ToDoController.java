package com.example.webapp.controller;

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
    
    @GetMapping("/search")
    public String search(
            String keyword,
            Model model) {

        model.addAttribute(
                "todos",
                toDoService.findByTodo(keyword));
        
        model.addAttribute(
                "keyword",
                keyword);

        return "todo/list";
    }

    /**
     * 一覧表示
     */
    @GetMapping
    public String list(Model model) {

        model.addAttribute(
            "todos",
            toDoService.findAllToDo());

        int completedCount =
                toDoService.getCompletedCount();

        model.addAttribute(
                "completedCount",
                completedCount);

        model.addAttribute(
                "aquarium",
                createAquarium(completedCount));

        return "todo/list";
    }

    /**
     * 詳細表示
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model,
            RedirectAttributes attributes) {
    	
        ToDo todo =toDoService.findByIdToDo(id);

        if (todo != null) {
            model.addAttribute("todo", todo);
            return "todo/detail";
        } else {
            attributes.addFlashAttribute(
                    "errorMessage",
                    "対象データがありません");
            return "redirect:/todos";
        }
    }

    /**
     * 新規登録画面表示
     */
    @GetMapping("/add")
    public String add(Model model) {

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

        ToDo todo = toDoService.findByIdToDo(id);

        if (todo == null) {
            attributes.addFlashAttribute(
                    "errorMessage",
                    "対象データがありません");
            return "redirect:/todos";
        }

        model.addAttribute(
                "todoForm",
                ToDoHelper.convertToDoForm(todo));

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

        if (result.hasErrors()) {
            model.addAttribute("todoForm", todoForm);
            return "todo/form";
        }

        ToDo todo = ToDoHelper.convertToDo(todoForm);

        if (todoForm.getIsNew()) {
            toDoService.insertToDo(todo);
            attributes.addFlashAttribute(
                    "message", "登録しました");
        } else {
            toDoService.updateToDo(todo);
            attributes.addFlashAttribute(
                    "message", "更新しました");
        }

        return "redirect:/todos";
    }
    
    @PostMapping("/delete/{id}")
    public String delete(
            @PathVariable Integer id,
            RedirectAttributes attributes) {

        toDoService.deleteToDo(id);

        attributes.addFlashAttribute(
                "message",
                "削除しました");

        return "redirect:/todos";
    }
    
    @PostMapping("/complete/{id}")
    public String complete(
            @PathVariable Integer id,
            RedirectAttributes attributes) {

        toDoService.complete(id);

        attributes.addFlashAttribute(
                "message",
                "完了しました");

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