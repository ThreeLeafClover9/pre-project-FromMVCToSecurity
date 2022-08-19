package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final Map<Long, Map<String, Object>> members = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> member = new HashMap<>();
        long memberId = 1L;
        member.put("memberId", memberId);
        member.put("email", "hgd@gmail.com");
        member.put("name", "홍길동");
        member.put("phone", "010-1234-5678");
        members.put(memberId, member);
    }

    @PostMapping
    public ResponseEntity postMember(@RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone) {
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("phone", phone);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        return new ResponseEntity<>("getMember() : " + memberId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        return new ResponseEntity<>("getMembers()", HttpStatus.OK);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestParam("phone") String phone) {
        Map<String, Object> member = members.get(memberId);
        member.put("phone", phone);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        members.remove(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
