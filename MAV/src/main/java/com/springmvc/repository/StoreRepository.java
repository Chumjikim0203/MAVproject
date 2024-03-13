package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Room;
import com.springmvc.domain.Store;

public interface StoreRepository {
    
    void createRoom(Room room);
    List<Room> getAllRooms(Room room);
	void deleteRoom(int roomNum);
	Room  getByroomNumAllRooms(int roomNum);
	void updateRoom(Room updateRoom);
	Room getByRoomNum(int roomNum);
	Store getStoreById(String storeId);
	List<Room> getRoomsByStoreId(String storeId);
	void CreateStore(Store store);
	void updateMatchedValue(int roomNum, int matchedValue);
   void UpdateStore(Store store);
   Store DeleteStore(String storeId);
}


/*
 * List<Room> getAllRoomsByStoreId(String storeId);
 */   