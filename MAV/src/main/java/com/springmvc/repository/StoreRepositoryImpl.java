package com.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Room;
import com.springmvc.domain.Store;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    private final JdbcTemplate jdbcTemplate;
    
    
    @Override
    public Store getStoreById(String storeId) {
        String sql = "SELECT * FROM Store WHERE storeId = ?";
        return jdbcTemplate.queryForObject(sql,new StoreRowMapper(),storeId);
    }


	//룸 넘버에 맞는 룸정보 들고 오기
    @Override
    public Room getByroomNumAllRooms(int roomNum) {
        String sql = "SELECT * FROM Room WHERE roomNum = ?";
        return jdbcTemplate.queryForObject(sql, new RoomRowMapper(), roomNum);
    }

    //객체생성
   @Autowired
    public StoreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   // 방 만들기
    @Override
    public void createRoom(Room room) {
        String sql = "INSERT INTO Room (storeId, roomName, roomCapacity, roomCount, roomCategory, roomDetail, roomDate, roomTime,isMatched) " +
        				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                room.getStoreId(),
                room.getRoomName(),
                room.getRoomCapacity(),
                room.getRoomCount(),
                room.getRoomCategory(),
                room.getRoomDetail(),
                room.getRoomDate(),
                room.getRoomTime(),
                room.isMatched()
        );
    }
    
    
    //방 전체 보여주기
    @Override
    public List<Room> getAllRooms(Room room) {
        String sql = "SELECT * FROM Room";
        return jdbcTemplate.query(sql, new RoomRowMapper());
    }

    @Override
    public Room getByRoomNum(int roomNum) {
        String sql = "SELECT * FROM Room WHERE roomNum = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{roomNum}, new RoomRowMapper());
    }
    
    //방삭제
    @Override
    public void deleteRoom(int roomNum) {
        String sql = "DELETE FROM Room WHERE roomNum = ?";
        jdbcTemplate.update(sql, roomNum);
    }
    
    // 방업데이트
    @Override
    public void updateRoom(Room updatedRoom) {
        String sql = "UPDATE Room SET storeId = ?, roomName = ?, roomCapacity = ?, roomCount = ?, roomCategory = ?, " +
                "roomDetail = ?, roomDate = ?, roomTime = ? WHERE roomNum = ?";
        jdbcTemplate.update(
                sql,
                updatedRoom.getStoreId(),
                updatedRoom.getRoomName(),
                updatedRoom.getRoomCapacity(),
                updatedRoom.getRoomCount(),
                updatedRoom.getRoomCategory(),
                updatedRoom.getRoomDetail(),
                updatedRoom.getRoomDate(),
                updatedRoom.getRoomTime(),
                updatedRoom.getRoomNum()
        );
    }
}








// 업체가 작성한 모든 방의 시간과 날짜만 가져오는 로직
   /*
@Override
public List<Room> getAllRoomsByStoreId(String storeId) {
    String sql = "SELECT roomNum, roomName, roomDate, roomTime FROM Room WHERE storeId = ?";
    return jdbcTemplate.query(sql, new Object[]{storeId}, new RoomRowMapper());
}
    */


// 한 업체가 작성한 모든방의 시간과 날짜만 가져오는 로직
   /*
    * @Override public List<Room> getAllRoomsByStoreId(String storeId) { // TODO
    * Auto-generated method stub return null; }
    */ 