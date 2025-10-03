package com.JPA.JPAAssig.DAO;

import com.JPA.JPAAssig.Entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Member> listAll(){
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Member updateMember(Long id, Member body){
        Member existing = entityManager.find(Member.class, id);
        if (existing == null) return null;
        existing.setFirstName(body.getFirstName());
        existing.setLastName(body.getLastName());
        existing.setEmail(body.getEmail());
        existing.setPhone(body.getPhone());
        existing.setAddress(body.getAddress());
        existing.setDateOfBirth(body.getDateOfBirth());
        return existing;
    }
}
