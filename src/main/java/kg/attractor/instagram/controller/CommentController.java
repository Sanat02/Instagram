package kg.attractor.instagram.controller;

import kg.attractor.instagram.dto.CommentDto;
import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.CommentService;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;

    @PostMapping()
    public HttpStatus addMessage(@RequestBody CommentDto commentDto, Authentication auth) {
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        commentDto.setUserId(userDto.getId());
        commentService.saveComment(commentDto);
        return HttpStatus.OK;
    }
}
