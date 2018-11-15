package lvergergsk.example.spring.web.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.util.HashMap

@Controller
@RequestMapping("/model")
class ModelController {
    @GetMapping("/showViewPage")
    fun passParametersWithModel(model: Model): String {
        val map = HashMap<String, String>()
        map["spring"] = "mvc"
        model.addAttribute("message", "showViewPage message.")
        model.mergeAttributes(map)
        return "viewPage"
    }

    @GetMapping("/printViewPage")
    fun passParametersWithModelMap(map: ModelMap): String {
        map.addAttribute("welcomeMessage", "welcome")
        map.addAttribute("message", "printViewPage message")
        return "viewPage"
    }

    @GetMapping("/goToViewPage")
    fun passParametersWithModelAndView(): ModelAndView {
        val modelAndView = ModelAndView("viewPage")
        modelAndView.addObject("message", "goToViewPage message")
        return modelAndView
    }
}
