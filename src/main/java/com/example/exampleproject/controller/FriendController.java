package com.example.exampleproject.controller;

import com.example.exampleproject.model.Buddy;
import com.example.exampleproject.model.Friend;
import com.example.exampleproject.model.Product;
import com.example.exampleproject.model.User;
import com.example.exampleproject.repository.BuddyRepository;
import com.example.exampleproject.repository.FriendRepository;
import com.example.exampleproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
public class FriendController {

    private FriendRepository friendRepository;

    private BuddyRepository buddyRepository;

    private UserRepository userRepository;
    @Autowired
    public FriendController(FriendRepository friendRepository, BuddyRepository buddyRepository, UserRepository userRepository) {
        this.friendRepository = friendRepository;
        this.buddyRepository = buddyRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/friend")
    public String findAll(@AuthenticationPrincipal UserDetails user, Model model) {
        User user1 = userRepository.findByUsername(user.getUsername());
        System.out.println(user1);
        int bId = 0;
        Collection<Buddy> buddies = buddyRepository.findAll();
        for (var b:buddies) {
            User user2 = b.getUser();
            if(user1.equals(user2)) {
                bId = b.getBuddyId();
            }
        }
        Buddy buddy = buddyRepository.getById(bId);
        List<Friend> friends = friendRepository.findAll();
        model.addAttribute("friends", friends);
        model.addAttribute("buddies", buddyRepository.findAll());
        model.addAttribute("buddy", buddy);
        return "friend";
    }

    @PostMapping("/friend")
    public String addFriend(@AuthenticationPrincipal UserDetails user, @RequestParam int idF) {
        User user1 =userRepository.findByUsername(user.getUsername());
        int bId = 0;
        Collection<Buddy> buddies = buddyRepository.findAll();
        for (var b:buddies) {
            User user2 = b.getUser();
            if(user1.equals(user2)) {
                bId = b.getBuddyId();
            }
        }
        Buddy buddy1 = buddyRepository.getById(bId);
        Friend friend = new Friend();
        friend.setBuddyId(idF);
        friend.setFriendId(buddy1.getBuddyId());
        Collection<Friend> friends = buddy1.getFriends();
        friends.add(friend);
        buddy1.setFriends(friends);
        friendRepository.save(friend);
        buddyRepository.save(buddy1);
        return "redirect:/friend";
    }
}
