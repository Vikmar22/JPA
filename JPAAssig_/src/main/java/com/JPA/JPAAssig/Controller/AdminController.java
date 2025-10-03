package com.JPA.JPAAssig.Controller;

import com.JPA.JPAAssig.Entity.Address;
import com.JPA.JPAAssig.Entity.Member;
import com.JPA.JPAAssig.Service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/members")
    public List<Member> findAllMembers() {
        return adminService.findAllMembers();
    }


    @GetMapping("/members/{id}")
    public List<Member> findMembersById(@PathVariable("id") int id) {
        adminService.findMemberById(id);
        return adminService.findMemberById(id);
    }

    @PostMapping("/members")
    public ResponseEntity<Member> addMember(@RequestBody Member body) {
        Member created = adminService.createMember(body);
        URI location = URI.create("/admin/members/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Member> memberUpdate(@PathVariable Long id, @RequestBody Member body) {
        Member updated = adminService.updateMember(id, body);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable Long id) {
        boolean deleted = adminService.deleteMember(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }






}
