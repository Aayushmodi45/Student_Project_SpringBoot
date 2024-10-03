package com.example.studentdemo.resource;

import com.example.studentdemo.model.Student;
import com.example.studentdemo.repository.StudentRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/studentdemo")
public class WebController {

    @Autowired
    StudentRepo sr;
    @RequestMapping(value = "/")
    public String getHome()
    {
        return "index";
    }
    @RequestMapping(value="/reg")
     public ModelAndView register(Model model,@RequestParam("mail")String mail,@RequestParam("pass")String pass,@RequestParam("sub")String sub)
    {
        ModelAndView mod = new ModelAndView();
        if(sub.equals("LOGIN"))
        {
            Student s = sr.findByMailAndPass(mail,pass);

            if(s==null)
            {
                model.addAttribute("msg","Invalid username or password");
                mod.setViewName("index");

            }
            else {
                mod.setViewName("success");
            }

        }
        else {
            mod.setViewName("register");
        }
        return mod;

    }
@RequestMapping(value="/regme")
public String registerMe(@RequestParam("mail")String mail, @RequestParam("pass")String pass, @RequestParam("name")String name, @RequestParam("mobile")String mobile)
{
    Student student = new Student(name,mail,pass,mobile);

    sr.save(student);  // insert query will be fired

    return "index";

}

@RequestMapping(value="/curd")
public ModelAndView getCurxd(Model modelObj,@RequestParam("sub")String sub)
{
    ModelAndView mod = new ModelAndView();

    if(sub.equals("SHOW")) {

        List<Student> stdlist = sr.findAll(); //it is default method
        modelObj.addAttribute("mylist", stdlist);

        mod.addObject(modelObj);
        mod.setViewName("show");
    }
    else if(sub.equals("DELETE"))
    {
        List<String> maillist = sr.showAllMail();
        modelObj.addAttribute("maillist",maillist);
        mod.addObject(modelObj);
        mod.setViewName("delete");

    }
    else if(sub.equals("UPDATE"))
    {
        List<String> stdup = sr.showAllMail();
        modelObj.addAttribute("stdup",stdup);
        mod.addObject(modelObj);
        mod.setViewName("updatedata");
    }
    else {
        mod.setViewName("register");
     }


    return mod;
}

@RequestMapping(value="/delme")
public String deleteme(@RequestParam("mail")String mail)
{

    sr.deleteByMail(mail);

    return "success";
}
@RequestMapping(value="/upme")
    public ModelAndView uprec(Model model,@RequestParam("mail")String mail)
{
    ModelAndView mod= new ModelAndView();
    Student st = sr.findByMail(mail);
    model.addAttribute("st",st);
    mod.addObject(model);
    mod.setViewName("updaterec");
    return mod;

}
@RequestMapping(value="updateit")
    public String updateme(@RequestParam("sid")String sid,@RequestParam("name")String name,@RequestParam("mail")String mail,@RequestParam("pass")String pass,@RequestParam("mobile") String mobile)
{
    sr.updateMe(Integer.parseInt(sid),name,mail,pass,mobile);
    return "success";
}



}
