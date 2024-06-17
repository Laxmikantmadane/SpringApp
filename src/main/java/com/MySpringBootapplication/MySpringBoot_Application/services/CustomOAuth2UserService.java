//package com.MySpringBootapplication.MySpringBoot_Application.services;
//
//import java.util.Collections;
//
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
//import org.springframework.stereotype.Service;
//
//import com.MySpringBootapplication.MySpringBoot_Application.Repository.UserRepository;
//import com.MySpringBootapplication.MySpringBoot_Application.entities.User;
//
//@Service
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//    private final UserRepository userRepository;
//
//    public CustomOAuth2UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
//        OAuth2User oAuth2User = delegate.loadUser(userRequest);
//
//        String email = oAuth2User.getAttribute("email");
//        User user = userRepository.findByUsername(email);
//        if (user == null) {
//            user = new User();
//            user.setEmail(email);
//            user.setUsername(oAuth2User.getAttribute("name"));
//            user.setProfilePicture(oAuth2User.getAttribute("picture"));
//            userRepository.save(user);
//        }
//
//        return new DefaultOAuth2User(Collections.singleton(new OAuth2UserAuthority(oAuth2User.getAttributes())), oAuth2User.getAttributes(), "sub");
//    }
//}