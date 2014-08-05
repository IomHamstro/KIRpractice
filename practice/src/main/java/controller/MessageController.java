package controller;

import model.Message;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.MessageService;
import service.UserService;

import java.util.Calendar;

/**
 * Created by Ольга on 04.08.2014.
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;


//    @RequestMapping("/message/{id}")
//    public ModelAndView getMessage(@PathVariable Long id) {
//        return new ModelAndView("messages", "message", messageService.getMessageById(id));
//    }

    @RequestMapping("/new-message")
    public ModelAndView createMessage() {
        ModelAndView mv = new ModelAndView("new-message");
        mv.addObject("message", new Message());
        return mv;
    }

    @ResponseBody
    @RequestMapping("/message/save")
    public ModelAndView saveMessage(Message message) {
        User author = new User();
        try {
           author = userService.getUserByName(message.getAuthor().getName());
        }catch (NullPointerException e){
            author.setId(3L);
            author.setName("Smith");
        }
        message.setAuthor(author);
        message.setDate(Calendar.getInstance().getTime());
        messageService.saveMessage(message);
        return new ModelAndView("redirect:" + "/messages");
    }

    @RequestMapping("/messages")
    public ModelAndView allMessages() {
        ModelAndView mv = new ModelAndView("messages");
        mv.addObject("allMessages", messageService.getAllMessages());
        return mv;
    }
}
