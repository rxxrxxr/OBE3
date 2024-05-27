package com.onezogreen.onezo3.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("menu")
@RequiredArgsConstructor
public class MenuController {

    public final MenuService menuService;

    @GetMapping("/soldOut/select/{store_id}")
    public List<MenuVo> selectMenu(@PathVariable Long store_id){
        List<MenuVo> menuList = menuService.menuSelect(store_id);
        return menuList;
    }

    @PutMapping("/soldOut/update/{store_id}/{menu_id}")
    public boolean changeSoldOut(@PathVariable Long store_id, @PathVariable Long menu_id, @RequestBody MenuVo menuVo){
        boolean soldOutCheck = menuService.soldOutChange(store_id, menu_id, menuVo);
        return true;
    }

}
