package com.unfbx.chatgptsteamoutput.controller;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author zhangxin
 * @date 2023-06-29 16:46
 */
@RestController
public class TestContoller {

    @Resource
    OpenAiClient openAiClient;

    @RequestMapping("/chatgptTest")
    public  void  test(){

        Message message = Message.builder().role(Message.Role.USER).content("写一篇800字的高考作文,题目跟2019年高考一卷一样").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(Arrays.asList(message)).build();
        ChatCompletionResponse chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);
        chatCompletionResponse.getChoices().forEach(e -> {
            System.out.println(e.getMessage()); });

    }


}
