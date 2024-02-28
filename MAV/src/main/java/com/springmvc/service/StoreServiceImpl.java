package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Room;
import com.springmvc.domain.Store;
import com.springmvc.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void createRoom(Room room) {
        storeRepository.createRoom(room);
    }
    // 스토어 넘버를 가지고 업데이트라인 뿌리기
    @Override
	public Room getByroomNumAllRooms(int roomNum) {
    	
		return storeRepository.getByroomNumAllRooms(roomNum);
	}


    // 전체를 가지고 오는거
	@Override
	public List<Room> getAllRooms(Room room) {
		return storeRepository.getAllRooms(room);
	}

	@Override
	public void deleteRoom(int roomNum) {
		storeRepository.deleteRoom(roomNum);
	}
	@Override
	public void updateRoom(Room updateRoom) {
		storeRepository.updateRoom(updateRoom);
		
	}
	@Override
	public void CreateStore(Store store) {
		storeRepository.CreateStore(store);
		
	}
}


//대경이행님이 로긴 만들면 값 가지고 와서 store들어가자 마자 뿌리기
//@Override
//public List<Room> getAllRoomsByStoreId(String storeId) {
//  return storeRepository.getAllRoomsByStoreId(storeId);
//}
