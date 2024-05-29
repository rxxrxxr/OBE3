package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.manager.ManagerVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final TokenManager tokenManager;

    @Operation(summary = "로그인",description = "db에 존재하는 아이디와 비밀번호를 사용해 로그인")
    @PostMapping("/login")
    public String token(@RequestBody LoginRequest loginRequest) {
        ManagerVo managerVo=loginService.logIn(loginRequest.getEmail(), loginRequest.getPassword());
        if(managerVo==null){
            throw new RuntimeException("회원이 아닙니다.");
        }
        return tokenManager.generateToken(managerVo);
    }

}
