package com.JPA.JPAAssig.Service;

import com.JPA.JPAAssig.DAO.MemberDAO;
import com.JPA.JPAAssig.Entity.Member;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberDAO memberDAO;

    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Transactional()
    public List<Member> listAll() {
        return memberDAO.listAll();
    }

    @Transactional()
    public Member updateMember(Long id, Member body){
        Member updatedMember = memberDAO.updateMember(id, body);
        if (updatedMember == null) return null;
        return updatedMember;
    }
}
