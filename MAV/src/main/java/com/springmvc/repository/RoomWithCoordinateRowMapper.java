package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Room;
import com.springmvc.domain.Store;

public class RoomWithCoordinateRowMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
        Room room = new Room();
        Store store = new Store();

        room.setRoomNum(rs.getInt("roomNum"));
        room.setRoomName(rs.getString("roomName"));
        room.setRoomCapacity(rs.getInt("roomCapacity"));
        room.setRoomCount(rs.getInt("roomCount"));
        room.setRoomCategory(rs.getString("roomCategory"));
        room.setRoomDetail(rs.getString("roomDetail"));
        room.setRoomDate(rs.getDate("roomDate").toLocalDate());
        room.setRoomTime(rs.getTime("roomTime").toLocalTime());
        room.setMatched(rs.getInt("matched"));

        store.setLatitude(rs.getDouble("latitude"));
        store.setLongitude(rs.getDouble("longitude"));

        room.setStore(store);

        return room;
    }
}
