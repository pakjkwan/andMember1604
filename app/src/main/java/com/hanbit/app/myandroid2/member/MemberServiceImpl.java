package com.hanbit.app.myandroid2.member;

import android.app.Activity;

import com.hanbit.app.myandroid2.member.MemberDAO;
import com.hanbit.app.myandroid2.member.MemberDTO;
import com.hanbit.app.myandroid2.member.MemberService;

import java.util.List;

/**
 * Created by USER on 2016-04-28.
 */
public class MemberServiceImpl extends Activity implements MemberService {
    @Override
    public void join(MemberDTO member) {
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        dao.insert(member);
    }

    @Override
    public MemberDTO login(MemberDTO member) {
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        return dao.login(member);
    }


    @Override
    public List<MemberDTO> findMembers() {
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        return dao.selectAll();
    }

    @Override
    public List<MemberDTO> findMembersByName(MemberDTO member) {
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        return dao.selectByName(member);
    }

    @Override
    public MemberDTO findMemberByID(MemberDTO member) {
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        return dao.selectByID(member);
    }

    @Override
    public int count() {
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        return dao.count();
    }

    @Override
    public void changMember(MemberDTO member) {
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
    }

    @Override
    public void remove(MemberDTO member) {
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
    }
}
