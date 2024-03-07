package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Room;
import com.springmvc.domain.Store;

public interface StoreRepository {
    
    void createRoom(Room room);
    List<Room> getAllRooms(Room room);
<<<<<<< HEAD
	void deleteRoom(int roomNum);
	Room  getByroomNumAllRooms(int roomNum);
	void updateRoom(Room updateRoom);
	Room getByRoomNum(int roomNum);
	Store getStoreById(String storeId);
	List<Room> getRoomsByStoreId(String storeId);
	void CreateStore(Store store);
	void updateMatchedValue(int roomNum, int matchedValue);
=======
   void deleteRoom(int roomNum);
   Room  getByroomNumAllRooms(int roomNum);
   void updateRoom(Room updateRoom);
   Room getByRoomNum(int roomNum);
   Store getStoreById(String storeId);
   List<Room> getRoomsByStoreId(String storeId);
   void CreateStore(Store store);
   void UpdateStore(Store store);
   void DeleteStore(String storeId);


>>>>>>> origin/PMS

}


/*
 * List<Room> getAllRoomsByStoreId(String storeId);
 */   