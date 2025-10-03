package com.JPA.JPAAssig.DAO;

import com.JPA.JPAAssig.Entity.Address;
import com.JPA.JPAAssig.Entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDAO {
    @PersistenceContext
    public EntityManager entityManager;

    public List<Member> findAllMembers() {
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findMembersById(int id) {
        return entityManager.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Member> findMembersByFirstName(String firstName) {
        return entityManager.createQuery("select m from Member m where m.firstName = :firstName", Member.class)
                .setParameter("firstName", firstName)
                .getResultList();

    }

    public List<Member> findMembersByLastName(String lastName) {
        return entityManager.createQuery("select m from Member m where m.lastName = :lastName", Member .class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    public List<Member> findMembersByEmail(String email) {
        return entityManager.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
    }

    public List<Member> findMembersByAddress(String address) {
        return entityManager.createQuery("select m from Member m where m.address = :address", Member.class)
                .setParameter("address", address)
                .getResultList();
    }

    public List<Member> findMembersByPhone(String phone) {
        return entityManager.createQuery("select m from Member m where m.phone = :phone", Member.class)
                .setParameter("phone", phone)
                .getResultList();
    }

    public List<Member> findMembersByDateOfBirth(String dateOfBirth) {
        return entityManager.createQuery("select m from Member m where m.dateOfBirth = :dateOfBirth", Member.class)
                .setParameter("dateOfBirth", dateOfBirth)
                .getResultList();
    }

    @Transactional
    public void saveMember(Member member) {
        entityManager.merge(member);
    }


    public Member createMember(Member m) {
        entityManager.merge(m);
        return m;
    }

    public Member updateMember(Long id, Member body) {
        Member existingMember = entityManager.find(Member.class, id);
        if  (existingMember == null) return null;
        existingMember.setFirstName(body.getFirstName());
        existingMember.setLastName(body.getLastName());
        existingMember.setEmail(body.getEmail());
        existingMember.setAddress(body.getAddress());
        existingMember.setPhone(body.getPhone());
        existingMember.setDateOfBirth(body.getDateOfBirth());
        return existingMember;


    }

    public boolean deleteMember(Long id) {
        Member existingMember = entityManager.find(Member.class, id);
        if (existingMember == null) return false;
        entityManager.remove(existingMember);
        return true;
    }


}
