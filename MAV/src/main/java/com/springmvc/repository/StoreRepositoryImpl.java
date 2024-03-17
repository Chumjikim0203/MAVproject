package com.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Room;
import com.springmvc.domain.Store;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    private final JdbcTemplate jdbcTemplate;
    
    //스토어 아이디에 맞는 룸 가지고 오기
    @Override
    public List<Room> getRoomsByStoreId(String storeId) {
        String sql = "SELECT * FROM Room WHERE storeId = ?";
        return jdbcTemplate.query(sql, new RoomRowMapper(), storeId);
    }
    
    
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

    //업데이트시에 사용
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
        String sql = "INSERT INTO Room (storeId, roomName, roomCapacity, roomCount, roomCategory, roomDetail, roomDate, roomTime,matched) " +
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
                room.getMatched()
        );
    }
    
    
    //방 전체 보여주기
    @Override
    public List<Room> getAllRooms(Room room) {
        String sql = "SELECT * FROM Room";
        return jdbcTemplate.query(sql, new RoomRowMapper());
    }
    
    //스토어아이디에 맞는 룸 불러오기
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
    
    public void CreateStore(Store store) {
        // TODO Auto-generated method stub
     //업체등록 

        store.setStoreApprove(true);
        String SQL="INSERT INTO Store (storeId,storeName,storeAddr,storeCategory,storePhone01,storePhone02,storePhone03,storeInfomation,storeNotice,storeCode,storeApprove)"
              +"values(?,?,?,?,?,?,?,?,?,?,?)";
        
        
          jdbcTemplate.update(SQL,

              store.getStoreId(),
              store.getStoreName(),
              store.getStoreAddr(),
              store.getStoreCategory(),
              store.getStorePhone01(),
              store.getStorePhone02(),
              store.getStorePhone03(),
              store.getStoreInfomation(),
              store.getStoreNotice(),
              store.getStoreCode(),
              store.isStoreApprove()
              );
     
     }

    //매칭 신청시 매치드 값 바꾸기
   @Override
   public void updateMatchedValue(int roomNum, int matchedValue) {
        String sql = "UPDATE Room SET matched = ? WHERE roomNum = ?";
        jdbcTemplate.update(sql, matchedValue,roomNum);      
   }


   @Override
   public void UpdateStore(Store store) {
      // TODO Auto-generated method stub
      String SQL="UPDATE "
            + "Store SET storeName=?,"
            + "storeAddr=?,"
            + "storeCategory=?,"
            + "storePhone01=?,"
            + "storePhone02=?,"
            + "storePhone03=?,"
            + "storeInfomation=?,"
            + "storeNotice=?,"
            + "storeCode=?"
            + "where storeId=?";
      jdbcTemplate.update(SQL,
            store.getStoreName(),
            store.getStoreAddr(),
            store.getStoreCategory(),
            store.getStorePhone01(),
            store.getStorePhone02(),
            store.getStorePhone03(),
            store.getStoreInfomation(),
            store.getStoreNotice(),
            store.getStoreCode(),
            store.getStoreId()
            );

   }


   @Override
   public void DeleteStore(String storeId) {
      // TODO Auto-generated method stub
      String SQL="DELETE FROM STORE WHERE storeId=?";
      this.jdbcTemplate.update(SQL,storeId);
   }


}