package com.JPA.JPAAssig.Service;

import com.JPA.JPAAssig.DAO.AdminDAO;

import com.JPA.JPAAssig.Entity.Address;
import com.JPA.JPAAssig.Entity.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {
private final AdminDAO adminDAO;


    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Transactional(readOnly = true)
    public List<Member> findAllMembers() {
        return adminDAO.findAllMembers();


    }

    @Transactional(readOnly = true)
    public List<Member> findMemberById(int id) {
        return adminDAO.findMembersById(id);
    }

    @Transactional(readOnly = true)
    public List<Member> findMemberByFirstName(String firstName) {
        return adminDAO.findMembersByFirstName(firstName);
    }

    @Transactional(readOnly = true)
    public List<Member> findMemberByLastName(String lastName) {
        return adminDAO.findMembersByLastName(lastName);
    }

    @Transactional(readOnly = true)
    public List<Member> findMemberByEmail(String email) {
        return adminDAO.findMembersByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<Member> findMemberByAddress(String address) {
        return adminDAO.findMembersByAddress(address);
    }

    @Transactional(readOnly = true)
    public List<Member> findMemberByPhone(String phone) {
        return adminDAO.findMembersByPhone(phone);
    }

    @Transactional(readOnly = true)
    public List<Member> findMemberByDateOfBirth(String dateOfBirth) {
        return adminDAO.findMembersByDateOfBirth(dateOfBirth);
    }


    @Transactional
    public Member createMember(Member m) {
        return adminDAO.createMember(m);
    }

    @Transactional
    public Member updateMember(Long id, Member body) {
        Member updatedMember = adminDAO.updateMember(id, body);
        if (updatedMember == null) return null;
        return updatedMember;
    }

    @Transactional
    public boolean deleteMember(Long id) {
        return adminDAO.deleteMember(id);
    }


}
