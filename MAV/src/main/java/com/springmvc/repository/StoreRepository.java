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
	void CreateStore(Store store);
}


/*
 * List<Room> getAllRoomsByStoreId(String storeId);
 */	