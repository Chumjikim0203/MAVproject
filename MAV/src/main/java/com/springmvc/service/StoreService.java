package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Room;
import com.springmvc.domain.Store;

public interface StoreService {
   void createRoom(Room room);
	List<Room> getAllRooms(Room room);
	void deleteRoom(int roomNum);
	Room getByroomNumAllRooms(int roomNum);
	void updateRoom(Room updateRoom);
	void CreateStore(Store store);
	Store getStoreById(String storeId);
<<<<<<< HEAD
=======
	List<Room> getRoomsByStoreId(String storeId);

>>>>>>> origin/KTY
}
//List<Room> getAllRoomsByStoreId(String storeId);