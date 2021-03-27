package service;

import java.util.ArrayList;

import entity.Member;

public class MemberServiceImpl implements MemberService {

    private static MemberServiceImpl service = new MemberServiceImpl();

    private MemberServiceImpl() {
    }

    public static MemberServiceImpl getInstance() {
        return service;
    }

    @Override
    public String greet(int i) {
        String[] greetings = { "Goot Morning", "Hello", "Goot evening" };
        return greetings[i];

    }

    @Override
    public ArrayList<Member> getAll() {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member(1, "Linda", "linda@example.com"));
        list.add(new Member(2, "James", "james@example.com"));
        return list;
    }

    @Override
    public int sumOf(int x, int y) {

        int sum = x;
        for (int i = 1; i <= y - x; i++) {
            sum += x + i;
        }

        return sum;
    }

}
