package kg.attractor.instagram.controller;



import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("hello","hi");
        return "registration";
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String addResume(
            @RequestParam(name = "account_name") String accountName,
            @RequestParam(name = "full_name") String fullName,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password

    ) {

        if (userService.isUserExist(email).equalsIgnoreCase("1")) {
            return "redirect:/register/error";
        } else {
            UserDto userDto = UserDto.builder()
                    .password(password)
                    .accountName(accountName)
                    .fullName(fullName)
                    .email(email)
                    .build();

            int userId = userService.save(userDto);
            return "redirect:/login";
        }
    }
}
