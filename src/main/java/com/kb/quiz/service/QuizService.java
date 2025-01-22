package com.kb.quiz.service;

import com.google.gson.Gson;
import com.kb.openAPI.dto.OpenApiResponseDTO;
import com.kb.openAPI.service.OpenAIService;
import com.kb.quiz.domain.Quiz;
import com.kb.quiz.dto.QuizAnswerDTO;
import com.kb.quiz.dto.QuizDTO;
import com.kb.quiz.dto.QuizResponse;
import com.kb.quiz.mapper.QuizMapper;
import com.kb.quizRecord.dto.QuizRecordDTO;
import com.kb.quizRecord.mapper.QuizRecordMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.json.simple.JSONObject;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class QuizService {

    private final QuizMapper quizMapper;
    private final OpenAIService openAIService;
    private final QuizRecordMapper quizRecordMapper;

    // 오늘의 퀴즈 가져오기
    public QuizDTO getTodayQuiz() {
        return quizMapper.getTodayQuiz();
    }

    // 학생의 퀴즈 답변 제출 처리
    public void submitQuizAnswer(QuizRecordDTO quizRecordDTO) {
        // 퀴즈 정답을 가져옴
        String correctAnswer = quizMapper.getCorrectAnswer(quizRecordDTO.getQuizId());

        // 제출된 답과 정답을 비교하여 정답 여부를 설정
        String isCorrect = quizRecordDTO.getIsCorrect().equals(correctAnswer) ? "Y" : "N";
        quizRecordDTO.setIsCorrect(isCorrect);
    }

    @Transactional
    public Quiz generateAndSaveQuiz() {
        // ChatGPT에게 전달할 프롬프트
        String prompt = "한국의 초등학생이 풀 수 있는 정도의 난이도로 네 개의 보기를 가진 객관식 경제 퀴즈를 만들어줘.";

        // ChatGPT에서 퀴즈 생성
        String response = openAIService.generateQuiz(prompt);

        Gson gson  = new Gson();


        OpenApiResponseDTO openApiResponseDTO = gson.fromJson(response, OpenApiResponseDTO.class);

        if (openApiResponseDTO == null || openApiResponseDTO.getChoices() == null || openApiResponseDTO.getChoices().isEmpty()) {
            throw new IllegalStateException("ChatGPT API 응답이 비어있거나 잘못되었습니다.");
        }

        String content = openApiResponseDTO.getChoices().get(0).getMessage().getContent();
        String replace = content.replace("```", "");
        String json = replace.replace("json", "");

        System.out.println(json);
        QuizResponse quizResponse = gson.fromJson(json, QuizResponse.class);
        if(quizResponse == null) {
            throw new IllegalStateException("quiz로 변환안됨..");
        }
        Quiz quiz = Quiz.toResponse(quizResponse);
        int result = quizMapper.insertQuiz(quiz);
        if(result != 1) {
            throw new IllegalStateException("quiz 저장되지 않음");
        }

        return quiz;
    }
}
