package com.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;
import com.springmvc.domain.Room;
import com.springmvc.domain.Store;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    private final JdbcTemplate jdbcTemplate;
    
    
<<<<<<< HEAD
    //스토어 아이디에 맞는 정보가지고 가기
    @Override
    public Store getStoreById(String storeId) {
        String sql = "SELECT * FROM Store WHERE storeId = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new StoreRowMapper(), storeId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
=======
>>>>>>> origin/PMS

    @Override
    public Room getByroomNumAllRooms(int roomNum) {
        String sql = "SELECT * FROM Room WHERE roomNum = ?";
        return jdbcTemplate.queryForObject(sql, new RoomRowMapper(), roomNum);
    }


   @Autowired
    public StoreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   // 방 만들기
    @Override
    public void createRoom(Room room) {
        String sql = "INSERT INTO Room (storeId, roomName, roomCapacity, roomCount, roomCategory, roomDetail, roomDate, roomTime) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                room.getStoreId(),
                room.getRoomName(),
                room.getRoomCapacity(),
                room.getRoomCount(),
                room.getRoomCategory(),
                room.getRoomDetail(),
                room.getRoomDate(),
                room.getRoomTime()
        );
    }
    
    
    //방 전체 정보가지고 오기
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
<<<<<<< HEAD
    
    
}
=======
   

    	public void CreateStore(Store store) {
    		// TODO Auto-generated method stub
    	//강사 등록	
    		store.setStoreApprove(true);
    		String SQL="INSERT INTO Store (storeId,storeName,storeAddr,storeCategory,storeCode,storePhone01,storePhone02,storePhone03,storeInfomation,storeNotice,storeApprove)"
    				+"values(?,?,?,?,?,?,?,?,?,?,?)";
    		jdbcTemplate.update(SQL,
    				store.getStoreId(),
    				store.getStoreName(),
    				store.getStoreAddr(),
    				store.getStoreCategory(),
    				store.getStoreCode(),
    				store.getStorePhone01(),
    				store.getStorePhone02(),
    				store.getStorePhone03(),
    				store.getStoreInfomation(),
    				store.getStoreNotice(),
    				store.isStoreApprove()
    				);
    	
    	}
    //단일출력

    }

    

>>>>>>> origin/PMS








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