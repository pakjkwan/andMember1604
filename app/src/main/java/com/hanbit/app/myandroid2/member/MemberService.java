package com.hanbit.app.myandroid2.member;

import com.hanbit.app.myandroid2.member.MemberDTO;

import java.util.List;

/**
 * Created by USER on 2016-04-28.
 */
public interface MemberService {
    public void join(MemberDTO member);
    public List<MemberDTO> findMembers();
    public List<MemberDTO> findMembersByName(MemberDTO member);
    public MemberDTO findMemberByID(MemberDTO member);
    public MemberDTO login(MemberDTO member);
    public int count();
    public void changMember(MemberDTO member);
    public void remove(MemberDTO member);
}
