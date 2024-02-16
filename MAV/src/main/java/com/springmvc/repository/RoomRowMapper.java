package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Room;

public class RoomRowMapper implements RowMapper<Room> {
   public Room mapRow(ResultSet rs, int rowNum)throws SQLException{
        Room room = new Room();
        room.setRoomNum(rs.getInt(1));
        room.setRoomId(rs.getString(2));
        room.setRoomName(rs.getString(3));
        room.setRoomCapacity(rs.getInt(4));
        room.setRoomCount(rs.getInt(5));
        room.setRoomCategory(rs.getString(6));
        room.setRoomDetail(rs.getString(7));
        room.setRoomDate(rs.getDate(8).toLocalDate());
        room.setRoomTime(rs.getTime(9).toLocalTime());
      return room;
   }
   
   
}