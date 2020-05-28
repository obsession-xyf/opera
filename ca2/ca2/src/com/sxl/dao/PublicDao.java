package com.sxl.dao;

import java.util.List;
import java.util.Map;

public interface PublicDao {
    List<Map> getList(String sql);
    List<Map> queryForList(String sql);
    
    
    int insert(String sql);
    
    int update(String sql);
    
    int delete(String sql);
    
    Map getMap(String sql);
    Map queryForMap(String sql);
    
    
}