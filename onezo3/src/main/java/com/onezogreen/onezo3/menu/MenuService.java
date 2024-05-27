package com.onezogreen.onezo3.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper menuMapper;

    public List<MenuVo> menuSelect(Long store_id){
        List<MenuVo> menuList = menuMapper.menuSelect(store_id);
        return menuList;
    }

    public boolean soldOutChange(Long store_id, Long menu_id, MenuVo menuVo){
        menuVo.setStore_id(store_id);
        menuVo.setMenu_id(menu_id);
        boolean soldOutCheck = menuMapper.soldOutChange(menuVo);
        return true;
    }
}
