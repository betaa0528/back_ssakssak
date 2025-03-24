package com.kb.emitter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmitterRepository {
    private Map<String, SseEmitter> emitterMap = new ConcurrentHashMap<>();

    public SseEmitter save(String userName, SseEmitter emitter) {
        emitterMap.put(userName, emitter);
        return emitter;
    }

    public void delete (String userName) {
        emitterMap.remove(userName);
    }

    public SseEmitter get (String userName) {
        return emitterMap.get(userName);
    }
}
