package com.springmvc.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class NotificationController {

    private final Map<String, SseEmitter> sseEmitters = new ConcurrentHashMap<>();

    @GetMapping(value = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)  
    public SseEmitter subscribe(String userId) {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE); // 타임아웃을 최대로 설정
        sseEmitters.put(userId, emitter);

        // 클라이언트 연결 종료 시, sseEmitters 목록에서 제거
        emitter.onCompletion(() -> sseEmitters.remove(userId));
        emitter.onTimeout(() -> sseEmitters.remove(userId));
        emitter.onError((e) -> sseEmitters.remove(userId));

        return emitter;
    }
	
    
    public void notifyUsersAboutMatching(String user1Id, String user2Id, String storeId) {
        String notificationMessage = "매칭이 성사되었습니다.";

        // 사용자1, 사용자2, 해당 업체에게 알림 보내기
        sendNotificationToUser(user1Id, notificationMessage);
        sendNotificationToUser(user2Id, notificationMessage);
        sendNotificationToUser(storeId, notificationMessage);
    }

    
    // 특정 사용자에게 알림을 보내는 메서드
    private void sendNotificationToUser(String userId, String message) {
        SseEmitter emitter = sseEmitters.get(userId);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().name("notification").data(message));
            } catch (Exception e) {
                sseEmitters.remove(userId); // 에러 발생 시 제거
            }
        }
    }
}
