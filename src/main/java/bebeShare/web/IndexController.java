package bebeShare.web;

import bebeShare.config.auth.LoginUser;
import bebeShare.config.auth.dto.SessionUser;
import bebeShare.service.PostsService;
import bebeShare.service.ProductService;
import bebeShare.service.UserService;
import bebeShare.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//test controller
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        return "views/main";
    }


    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @DeleteMapping("/api/v1/posts/{id}")
    @ResponseBody
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/product/detail")
    public String detailProduct(Model model) {
        return "product/detail";
    }

    @GetMapping("/product/register")
    public String registerProduct(Model model) {
        return "product/register";
    }

    @GetMapping("/user/mypage")
    public String mypage(Model model ,  @LoginUser SessionUser user) {
        model.addAttribute("user", userService.findById(user.getId()));
        return "user/mypage";
    }
}
