package com.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Room;

@Repository 
public class StoreRepositoryImpl implements StoreRepository {

   /*
    * @Override public Room save(Room room) { return room; }
    */
   
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public StoreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
   public StoreRepositoryImpl() {
	}

//업체가 방을 만드는 라인
   @Override
   public void createRoom(Room room) {
      System.out.println(room.getRoomTime() + " :리파지토리 입니다");
      
      
    String sql = "INSERT INTO Room (roomNum,roomId, roomName, roomCapacity, roomCount, roomCategory, roomDetail, roomDate, roomTime)"
    		+ " VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                room.getRoomNum(),
                room.getRoomId(),
                room.getRoomName(),
                room.getRoomCapacity(),
                room.getRoomCount(),
                room.getRoomCategory(),
                room.getRoomDetail(),
                room.getRoomDate(),
                room.getRoomTime()
        );     
   }
   
   

   // 모든 방 정보 가져오는것
   @Override
   public List<Room> getAllRooms(Room room) {
       String sql = "SELECT * FROM room ";
       return jdbcTemplate.query(sql, new RoomRowMapper());
   }
   
   
   // roomnum로 조회하는 로직
   @Override
   public Room getByroomNumAllRooms(int roomNum) {
       String sql = "SELECT * FROM room where roomNum = ? ";
       return (Room)jdbcTemplate.queryForObject(sql,new Object[] {roomNum},new RoomRowMapper());
   }
   
   




	//방을 삭제하는 로직
	@Override
	public void deleteRoom(int roomNum) {
	    String sql = "DELETE FROM Room WHERE roomNum = ?";
	    jdbcTemplate.update(sql, roomNum);
	}

	@Override
	public void updateRoom(Room updateRoom) {
		String sql = "UPDATE room SET roomId=?, roomName=?, roomCapacity=?, roomCount=?, roomCategory=?, roomDetail=?, roomDate=?, roomTime=? WHERE roomNum=?";
		jdbcTemplate.update(
		        sql,
		        updateRoom.getRoomId(),
		        updateRoom.getRoomName(),
		        updateRoom.getRoomCapacity(),
		        updateRoom.getRoomCount(),
		        updateRoom.getRoomCategory(),
		        updateRoom.getRoomDetail(),
		        updateRoom.getRoomDate(),
		        updateRoom.getRoomTime(),
		        updateRoom.getRoomNum()
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