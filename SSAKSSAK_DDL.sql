drop schema ssakssak;
create schema ssakssak;
use ssakssak;

-- 학생 테이블
drop table if exists Student;
CREATE TABLE Student (
                         `std_id`	BIGINT PRIMARY KEY	NOT NULL	AUTO_INCREMENT,
                         `tch_id`	BIGINT	NOT NULL,
                         `std_num`	INT	NULL,
                         `std_name`	VARCHAR(30)	NULL,
                         `std_account`	VARCHAR(30)	NULL,
                         `std_pw`	VARCHAR(20)	NULL,
                         `std_birth`	VARCHAR(10)	NULL,
                         `job_Id`	BIGINT	NULL,
                         `seed`	INT	NULL
);

INSERT INTO Student (tch_id, std_num, std_name, std_account, std_pw, std_birth, job_Id, seed)
VALUES
    (1, 1, '박민주', 'minjup', 'pass1234', '2010-05-01', 1, 3500),
    (1, 2, '한가연', 'gayeonh', 'pass1234', '2010-06-15', 2, 3000),
    (1, 3, '정인겸', 'ingyeomj', 'pass1234', '2010-04-20', 3, 2700),
    (1, 4, '고대호', 'daehoh', 'pass1234', '2010-09-11', 4, 2500),
    (1, 5, '유진', 'jinnyu', 'pass1234', '2010-07-30', 5, 4000),
    (1, 6, '김수현', 'soohyun', 'pass1234', '2010-11-05', 6, 2400),
    (1, 7, '이서연', 'seoyeonl', 'pass1234', '2010-08-21', 7, 3200),
    (1, 8, '오준서', 'junseo', 'pass1234', '2010-03-15', 8, 3300),
    (1, 9, '최유리', 'yurichoi', 'pass1234', '2010-12-02', 1, 2900),
    (1, 10, '강다니엘', 'danielk', 'pass1234', '2010-01-10', 1, 3600),
    (1, 11, '김태희', 'taheek', 'pass1234', '2010-04-05', 1, 2800),
    (1, 12, '박지훈', 'jihoonp', 'pass1234', '2010-06-25', 1, 3100),
    (1, 13, '정해인', 'haeinj', 'pass1234', '2010-02-16', 1, 2900),
    (1, 14, '윤아름', 'areumy', 'pass1234', '2010-09-18', 1, 3400),
    (1, 15, '송혜교', 'hyekyos', 'pass1234', '2010-10-22', 1, 3100),
    (1, 16, '이영애', 'yongael', 'pass1234', '2010-12-30', 1, 2600),
    (1, 17, '한석규', 'seokkyuh', 'pass1234', '2010-05-08', 1, 3700),
    (1, 18, '김소현', 'sohyunk', 'pass1234', '2010-07-13', 1, 3300),
    (1, 19, '이민호', 'minhol', 'pass1234', '2010-03-21', 1, 3200),
    (1, 20, '서강준', 'gangjoons', 'pass1234', '2010-11-16', 1, 3000);

-- 적금 테이블
drop table if exists Saving;
CREATE TABLE Saving (
                        `saving_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                        `product`	VARCHAR(50)	NULL,
                        `max_deposit`	INT	NULL,
                        `deposit_period`	INT	NULL,
                        `rate`	INT	NULL,
                        `isPrime`	CHAR(1)	NULL
);

INSERT INTO Saving (product, max_deposit, deposit_period, rate, isPrime)
VALUES
    ('새싹 적금', 30, 14, 2, 'Y'),  -- 새싹 적금: 2주, 매일 30씨드 최대, 기본 금리 2%, 우대 금리 5%
    ('나무 적금', 300, 28, 5, 'N'), -- 나무 적금: 4주, 매주 300씨드 최대, 기본 금리 5%
    ('숲속 적금', 300, 56, 15, 'N'); -- 숲속 적금: 8주, 매주 300씨드 최대, 기본 금리 15%

-- 적금 가입 테이블
drop table if exists saving_account;
CREATE TABLE Saving_account (
                                `account_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                                `std_id`	BIGINT	NOT NULL,
                                `tch_id`	BIGINT	NOT NULL,
                                `saving_id`	BIGINT	NOT NULL,
                                `rate`	INT	NULL,
                                `deposit_amount`	INT	NULL,
                                `start_date`	DATETIME	NULL,
                                `end_date`	DATETIME	NULL,
                                `status`	CHAR(1)	NULL,
                                `total_amount`	INT	NULL
);

INSERT INTO Saving_account (std_id, tch_id, saving_id, rate, deposit_amount, start_date, end_date, status, total_amount)
VALUES
    (1, 1, 1, 2, 30, '2024-01-01', '2024-01-15', 'Y', 420), -- 새싹 적금 만기 완료
    (2, 1, 2, 5, 300, '2024-01-01', '2024-01-29', 'N', 1200), -- 나무 적금 진행 중
    (3, 1, 3, 15, 300, '2024-02-01', '2024-03-28', 'Y', 2400), -- 숲속 적금 만기 완료
    (4, 1, 1, 5, 30, '2024-03-01', '2024-03-15', 'N', 300), -- 새싹 적금 진행 중
    (5, 1, 2, 5, 300, '2024-01-15', '2024-02-12', 'Y', 1200), -- 나무 적금 만기 완료
    (6, 1, 1, 2, 30, '2024-03-10', '2024-03-24', 'N', 300), -- 새싹 적금 진행 중
    (7, 1, 3, 15, 300, '2024-04-01', '2024-05-26', 'Y', 2400), -- 숲속 적금 만기 완료
    (8, 1, 2, 5, 300, '2024-02-01', '2024-02-28', 'Y', 1200), -- 나무 적금 만기 완료
    (9, 1, 1, 2, 30, '2024-02-15', '2024-02-29', 'Y', 420), -- 새싹 적금 만기 완료
    (10, 1, 2, 5, 300, '2024-02-10', '2024-03-09', 'N', 900), -- 나무 적금 진행 중
    (11, 1, 3, 15, 300, '2024-03-15', '2024-05-10', 'N', 1800), -- 숲속 적금 진행 중
    (12, 1, 1, 5, 30, '2024-02-01', '2024-02-15', 'Y', 450), -- 새싹 적금 만기 완료
    (13, 1, 2, 5, 300, '2024-03-01', '2024-03-28', 'N', 600), -- 나무 적금 진행 중
    (14, 1, 3, 15, 300, '2024-02-05', '2024-03-31', 'Y', 2400), -- 숲속 적금 만기 완료
    (15, 1, 1, 2, 30, '2024-04-01', '2024-04-15', 'N', 300), -- 새싹 적금 진행 중
    (16, 1, 2, 5, 300, '2024-03-01', '2024-03-29', 'Y', 1200), -- 나무 적금 만기 완료
    (17, 1, 3, 15, 300, '2024-03-15', '2024-05-10', 'N', 1800), -- 숲속 적금 진행 중
    (18, 1, 1, 2, 30, '2024-01-01', '2024-01-15', 'Y', 420), -- 새싹 적금 만기 완료
    (19, 1, 2, 5, 300, '2024-02-01', '2024-02-28', 'Y', 1200), -- 나무 적금 만기 완료
    (20, 1, 3, 15, 300, '2024-02-10', '2024-04-06', 'Y', 2400); -- 숲속 적금 만기 완료


-- 직업 테이블
drop table if exists job;
CREATE TABLE Job (
                     `job_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                     `std_id`	BIGINT	NOT NULL,
                     `tch_id`	BIGINT	NOT NULL,
                     `job_name`	VARCHAR(50)	NULL,
                     `isPrime`	CHAR(1)	NULL
);

INSERT INTO Job (std_id, tch_id, job_name, isPrime)
VALUES
    (1, 1, '회사원', 'N'),  -- 기본 직업
    (2, 1, '경찰', 'N'),
    (3, 1, '환경미화원', 'Y'), -- 우대 직업
    (4, 1, '우체부', 'Y'),  -- 우대 직업
    (5, 1, '낙농협회장', 'Y'), -- 우대 직업
    (6, 1, '한국전력공사대표', 'N'),
    (7, 1, '사서', 'Y'),    -- 우대 직업
    (8, 1, '통계청장', 'N');



-- 주식 등락 내역 테이블
drop table if exists rate_hitsory;
CREATE TABLE rate_history(
                             `rate_history_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                             `stock_date`	DATETIME	NULL,
                             `change`	INT	NULL,
                             `stock_price`	INT	NULL
);

-- 데이터 삽입
INSERT INTO rate_history (stock_date, `change`, stock_price) VALUES
                                                           ('2024-09-01', 5, 105),
                                                           ('2024-09-02', -4, 101),
                                                           ('2024-09-03', -5, 96),
                                                           ('2024-09-04', -1, 95),
                                                           ('2024-09-05', -2, 93),
                                                           ('2024-09-06', 3, 96),
                                                           ('2024-09-07', -1, 95),
                                                           ('2024-09-08', 0, 95),
                                                           ('2024-09-09', 4, 99),
                                                           ('2024-09-10', -2, 97),
                                                           ('2024-09-11', 1, 98),
                                                           ('2024-09-12', -1, 97),
                                                           ('2024-09-13', 2, 99),
                                                           ('2024-09-14', 5, 104),
                                                           ('2024-09-15', -3, 101),
                                                           ('2024-09-16', -4, 97),
                                                           ('2024-09-17', 0, 97),
                                                           ('2024-09-18', 3, 100),
                                                           ('2024-09-19', -5, 95),
                                                           ('2024-09-20', 1, 96),
                                                           ('2024-09-21', -2, 94),
                                                           ('2024-09-22', 2, 96),
                                                           ('2024-09-23', -4, 92),
                                                           ('2024-09-24', 0, 92),
                                                           ('2024-09-25', 5, 97),
                                                           ('2024-09-26', -3, 94),
                                                           ('2024-09-27', 2, 96),
                                                           ('2024-09-28', 1, 97),
                                                           ('2024-09-29', -1, 96),
                                                           ('2024-09-30', 3, 99),
                                                           ('2024-10-01', 3, 99),
                                                           ('2024-10-02', 3, 99);


-- 주식 거래 내역 테이블
drop table if exists stock_trade;
CREATE TABLE Stock_trade (
                             `trade_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                             `std_id`	BIGINT	NOT NULL,
                             `tch_id`	BIGINT	NOT NULL,
                             `trade_type`	CHAR(1)	NULL,
                             `quantity`	INT	NULL,
                             `stock_price`	INT	NULL,
                             `trade_date`	DATETIME	NULL
);

-- 학생 1: 주식을 3번 매수(B), 2번 매도(S)
INSERT INTO Stock_trade (std_id, tch_id, trade_type, quantity, stock_price, trade_date) VALUES
                                                                                            (1, 1, 'B', 50, 100, '2024-01-05'),   -- 매수: 50주, 100 씨드
                                                                                            (1, 1, 'B', 30, 102, '2024-01-10'),   -- 매수: 30주, 102 씨드
                                                                                            (1, 1, 'S', 20, 105, '2024-01-15'),   -- 매도: 20주, 105 씨드
                                                                                            (1, 1, 'B', 25, 103, '2024-01-20'),   -- 매수: 25주, 103 씨드
                                                                                            (1, 1, 'S', 40, 107, '2024-01-25');   -- 매도: 40주, 107 씨드

-- 학생 2: 주식을 2번 매수(B), 1번 매도(S)
INSERT INTO Stock_trade (std_id, tch_id, trade_type, quantity, stock_price, trade_date) VALUES
                                                                                            (2, 1, 'B', 60, 110, '2024-01-08'),   -- 매수: 60주, 110 씨드
                                                                                            (2, 1, 'S', 30, 115, '2024-01-18'),   -- 매도: 30주, 115 씨드
                                                                                            (2, 1, 'B', 20, 112, '2024-01-28');   -- 매수: 20주, 112 씨드

-- 학생 3: 주식을 4번 매수(B), 2번 매도(S)
INSERT INTO Stock_trade (std_id, tch_id, trade_type, quantity, stock_price, trade_date) VALUES
                                                                                            (3, 1, 'B', 40, 95, '2024-01-03'),    -- 매수: 40주, 95 씨드
                                                                                            (3, 1, 'B', 50, 97, '2024-01-12'),    -- 매수: 50주, 97 씨드
                                                                                            (3, 1, 'S', 30, 105, '2024-01-20'),   -- 매도: 30주, 105 씨드
                                                                                            (3, 1, 'B', 30, 100, '2024-01-22'),   -- 매수: 30주, 100 씨드
                                                                                            (3, 1, 'S', 40, 110, '2024-01-30');   -- 매도: 40주, 110 씨드

-- 주식 뉴스 테이블
drop table if exists stock_news;
CREATE TABLE Stock_news (
                            `news_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                            `title`	VARCHAR(100)	NULL,
                            `content`	VARCHAR(1000)	NULL,
                            `news_date`	DATETIME	NULL,
                            `status` char(1) default 'y' check (status in ('y', 'n'))
);


INSERT INTO Stock_news (title, content, news_date, status) VALUES
                                                       ('싹싹 주식회사 주가 상승', '싹싹 주식회사의 주가가 오늘 크게 올랐습니다. 많은 사람들이 이 회사의 성장에 대해 기대하고 있습니다.', '2024-01-01', 'y'),
                                                       ('싹싹 주식회사 주가 하락', '싹싹 주식회사의 주가가 오늘 떨어졌습니다. 하지만 전문가들은 다시 오를 것이라고 말하고 있습니다.', '2024-01-02', 'y'),
                                                       ('싹싹 주식회사 신제품 출시', '싹싹 주식회사가 새로운 제품을 출시했습니다. 이 제품은 많은 사람들에게 인기를 끌 것으로 보입니다.', '2024-01-03', 'y'),
                                                       ('싹싹 주식회사 매출 증가', '싹싹 주식회사의 매출이 이번 달 크게 증가했습니다. 회사는 더 많은 수익을 내기 위해 노력하고 있습니다.', '2024-01-04', 'y'),
                                                       ('싹싹 주식회사 매출 감소', '싹싹 주식회사의 매출이 이번 달 조금 줄었습니다. 하지만 회사는 새로운 전략을 준비하고 있습니다.', '2024-01-05', 'y'),
                                                       ('싹싹 주식회사 새로운 투자 유치', '싹싹 주식회사가 큰 투자를 받았습니다. 이 돈으로 회사는 더 큰 성장을 기대하고 있습니다.', '2024-01-06', 'y'),
                                                       ('싹싹 주식회사 공장 증설', '싹싹 주식회사가 공장을 더 크게 만들었습니다. 앞으로 더 많은 제품을 만들 수 있을 것입니다.', '2024-01-07', 'y'),
                                                       ('싹싹 주식회사 해외 진출 성공', '싹싹 주식회사가 해외에서 성공적으로 사업을 확장했습니다. 이제 더 많은 나라에서 제품을 만날 수 있습니다.', '2024-01-08', 'y'),
                                                       ('싹싹 주식회사 주가 다시 회복', '싹싹 주식회사의 주가가 오늘 다시 회복되었습니다. 투자자들은 매우 기뻐하고 있습니다.', '2024-01-09', 'y'),
                                                       ('싹싹 주식회사 신기술 개발', '싹싹 주식회사가 새로운 기술을 개발했습니다. 이 기술은 회사의 경쟁력을 높여줄 것입니다.', '2024-01-10', 'y'),
                                                       ('싹싹 주식회사 큰 수익 달성', '싹싹 주식회사가 이번 달 큰 수익을 냈습니다. 많은 사람들이 이 회사에 관심을 가지고 있습니다.', '2024-01-11', 'y'),
                                                       ('싹싹 주식회사 수익 감소', '싹싹 주식회사의 수익이 이번 달 줄어들었습니다. 하지만 회사는 이를 극복하기 위해 새로운 계획을 세우고 있습니다.', '2024-01-12', 'y'),
                                                       ('싹싹 주식회사 경영진 교체', '싹싹 주식회사의 경영진이 새롭게 바뀌었습니다. 이제 더 좋은 성과를 기대할 수 있습니다.', '2024-01-13', 'y'),
                                                       ('싹싹 주식회사 환경 보호 캠페인', '싹싹 주식회사가 환경 보호 캠페인을 시작했습니다. 많은 사람들이 이 회사의 노력을 칭찬하고 있습니다.', '2024-01-14', 'y'),
                                                       ('싹싹 주식회사 신입 직원 채용', '싹싹 주식회사가 새로운 직원을 채용하고 있습니다. 회사는 앞으로 더 성장할 준비를 하고 있습니다.', '2024-01-15', 'y'),
                                                       ('싹싹 주식회사 새로운 광고 시작', '싹싹 주식회사가 새로운 광고를 시작했습니다. 더 많은 사람들이 이 회사를 알게 될 것입니다.', '2024-01-16', 'y'),
                                                       ('싹싹 주식회사 주가 안정', '싹싹 주식회사의 주가가 오늘 안정적으로 유지되었습니다. 많은 투자자들이 안심하고 있습니다.', '2024-01-17', 'y'),
                                                       ('싹싹 주식회사 투자자들 환호', '싹싹 주식회사가 새로운 투자로 인해 투자자들에게 큰 기쁨을 주고 있습니다.', '2024-01-18', 'y'),
                                                       ('싹싹 주식회사 새로운 파트너십', '싹싹 주식회사가 다른 회사와 새로운 파트너십을 맺었습니다. 이를 통해 더 큰 성장을 기대하고 있습니다.', '2024-01-19', 'y'),
                                                       ('싹싹 주식회사 새로운 파트너십1', '싹싹 주식회사가 다른 회사와 새로운 파트너십을 맺었습니다. 이를 통해 더 큰 성장을 기대하고 있습니다.', '2024-01-19', 'n'),
                                                       ('싹싹 주식회사 새로운 파트너십2', '싹싹 주식회사가 다른 회사와 새로운 파트너십을 맺었습니다. 이를 통해 더 큰 성장을 기대하고 있습니다.', '2024-01-19', 'n'),
                                                       ('싹싹 주식회사 새로운 파트너십3', '싹싹 주식회사가 다른 회사와 새로운 파트너십을 맺었습니다. 이를 통해 더 큰 성장을 기대하고 있습니다.', '2024-01-19', 'n'),
                                                       ('싹싹 주식회사 새로운 파트너십4', '싹싹 주식회사가 다른 회사와 새로운 파트너십을 맺었습니다. 이를 통해 더 큰 성장을 기대하고 있습니다.', '2024-01-19', 'n'),
                                                       ('싹싹 주식회사 성장 기대감 상승', '싹싹 주식회사가 앞으로 더 크게 성장할 것으로 기대되고 있습니다. 많은 사람들이 이 회사에 주목하고 있습니다.', '2024-01-20', 'y');


CREATE TABLE Holding_stock (
                               std_id BIGINT NOT NULL,              -- 학생 ID
                               total_quantity INT NOT NULL,         -- 보유 주식 수량
                               total_investment DECIMAL(15, 2),     -- 총 투자 원금
                               average_price DECIMAL(15, 2),        -- 주당 평균 매수 가격
                               current_value DECIMAL(15, 2),        -- 현재 주식 평가액
                               profit_loss DECIMAL(15, 2),          -- 현재 수익금
                               profit_rate DECIMAL(15, 2),          -- 현재 수익률
                               PRIMARY KEY (std_id)
);

INSERT INTO Holding_stock (std_id, total_quantity, total_investment, average_price, current_value, profit_loss, profit_rate)
VALUES
    (1, 45, 4153.33, 101.41, 4950, 796.67, 19.18);

INSERT INTO Holding_stock (std_id, total_quantity, total_investment, average_price, current_value, profit_loss, profit_rate)
VALUES
    (2, 50, 5540, 110.8, 5500, -40, -0.72);

INSERT INTO Holding_stock (std_id, total_quantity, total_investment, average_price, current_value, profit_loss, profit_rate)
VALUES
    (3, 50, 3897.53, 97.53, 5500, 1602.47, 41.11);

-- 쿠폰 테이블
drop table if exists coupon;
CREATE TABLE `coupon` (
                          `cp_ID`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                          `cp_name`	VARCHAR(50)	NULL,
                          `cp_content`	VARCHAR(300)	NULL,
                          `cp_quantity`	INT	NULL,
                          `cp_price`	INT	NULL
);

INSERT INTO coupon (cp_name, cp_content, cp_quantity, cp_price) VALUES
                                                                    ('하루 자리 바꾸기 쿠폰', '선생님의 말을 잘 들으면 하루 동안 원하는 곳에 자리를 바꿀 수 있는 쿠폰입니다.', 6, 395),
                                                                    ('점심시간 추가 쿠폰', '점심시간을 10분 더 즐길 수 있는 쿠폰입니다. 하루 동안만 사용 가능합니다.', 3, 422),
                                                                    ('숙제 면제 쿠폰', '하루 동안 숙제를 면제받을 수 있는 특별한 쿠폰입니다. 책임감 있게 사용하세요!', 1, 451),
                                                                    ('친구와 같이 앉기 쿠폰', '친구와 원하는 자리에 앉을 수 있는 쿠폰입니다. 단 하루만 가능합니다.', 5, 127),
                                                                    ('교실 청소 면제 쿠폰', '교실 청소를 하루 동안 면제받을 수 있는 쿠폰입니다. 모두가 바라는 쿠폰이죠!', 8, 177),
                                                                    ('자습 시간 자유 쿠폰', '자습 시간에 자유롭게 시간을 보낼 수 있는 쿠폰입니다. 하루에 한 번만 사용 가능합니다.', 2, 176),
                                                                    ('좋아하는 책 읽기 시간 쿠폰', '좋아하는 책을 읽을 수 있는 특별한 시간이 주어지는 쿠폰입니다.', 2, 388),
                                                                    ('조용한 시간 면제 쿠폰', '교실에서 조용히 있는 시간을 면제받을 수 있는 쿠폰입니다. 하루 동안만 적용됩니다.', 7, 255),
                                                                    ('학교 가기 5분 늦기 쿠폰', '학교에 5분 늦게 도착해도 괜찮은 쿠폰입니다. 하지만 한 번만 사용할 수 있습니다.', 8, 143),
                                                                    ('하루 교실 발표 면제 쿠폰', '하루 동안 교실 발표에서 면제될 수 있는 쿠폰입니다. 발표가 어려운 학생들에게 추천합니다.', 2, 227);



-- 매점 거래 테이블
drop table if exists store;
CREATE TABLE `store` (
                         `store_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                         `cp_id`	BIGINT	NOT NULL,
                         `std_id`	BIGINT	NOT NULL,
                         `store_date`	DATE	NULL,
                         `quantity`	INT	NULL
);

INSERT INTO store (cp_id, std_id, store_date, quantity) VALUES
                                                            (3, 10, '2024-01-18', 1),
                                                            (9, 14, '2024-01-03', 2),
                                                            (2, 15, '2024-01-31', 1),
                                                            (3, 16, '2024-01-30', 3),
                                                            (9, 9, '2024-01-14', 4),
                                                            (8, 8, '2024-01-15', 5),
                                                            (3, 13, '2024-01-07', 5),
                                                            (9, 5, '2024-01-28', 1),
                                                            (5, 14, '2024-01-11', 5),
                                                            (5, 1, '2024-01-10', 3),
                                                            (10, 19, '2024-01-22', 4),
                                                            (3, 15, '2024-01-18', 4),
                                                            (6, 11, '2024-01-18', 5),
                                                            (7, 15, '2024-01-30', 3),
                                                            (4, 8, '2024-01-19', 4),
                                                            (4, 14, '2024-01-02', 3),
                                                            (8, 13, '2024-01-13', 2),
                                                            (8, 2, '2024-01-05', 5),
                                                            (10, 11, '2024-01-28', 1),
                                                            (8, 4, '2024-01-17', 4),
                                                            (1, 5, '2024-01-14', 2),
                                                            (2, 16, '2024-01-26', 3),
                                                            (6, 20, '2024-01-23', 4),
                                                            (2, 11, '2024-01-28', 5),
                                                            (7, 11, '2024-01-21', 4),
                                                            (9, 2, '2024-01-20', 1),
                                                            (4, 10, '2024-01-08', 1),
                                                            (7, 4, '2024-01-25', 1),
                                                            (8, 6, '2024-01-23', 3),
                                                            (1, 2, '2024-01-11', 1);

-- 학생 보유 쿠폰 테이블
drop table if exists student_coupon;
CREATE TABLE `student_coupon` (
                                  `stcp_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                                  `cp_ID`	BIGINT	NOT NULL,
                                  `std_id`	BIGINT	NOT NULL,
                                  `cp_quantity`	INT	NULL
);

INSERT INTO student_coupon (cp_ID, std_id, cp_quantity) VALUES
                                                            (5, 12, 3),
                                                            (7, 5, 2),
                                                            (9, 14, 5),
                                                            (3, 6, 2),
                                                            (2, 20, 4),
                                                            (10, 8, 4),
                                                            (10, 5, 2),
                                                            (8, 9, 4),
                                                            (5, 1, 4),
                                                            (5, 18, 2),
                                                            (2, 15, 3),
                                                            (10, 10, 4),
                                                            (5, 15, 3),
                                                            (4, 13, 4),
                                                            (2, 8, 4),
                                                            (10, 12, 5),
                                                            (5, 10, 1),
                                                            (7, 9, 1),
                                                            (10, 2, 5),
                                                            (8, 10, 2),
                                                            (10, 12, 2),
                                                            (4, 20, 3),
                                                            (3, 4, 1),
                                                            (5, 15, 1),
                                                            (10, 12, 2),
                                                            (2, 10, 3),
                                                            (7, 6, 2),
                                                            (3, 18, 3),
                                                            (9, 17, 3),
                                                            (3, 9, 4);


-- 리워드 테이블
drop table if exists reward;
CREATE TABLE Reward (
                        `reward_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                        `reward_name`	VARCHAR(100)	NULL,
                        `reward_seed`	INT	NULL
);

INSERT INTO Reward (reward_name, reward_seed) VALUES
                                                  ('교실 청소 도우미', 150),
                                                  ('쓰레기 줍기', 100),
                                                  ('친구 도와주기', 200),
                                                  ('질서 잘 지키기', 120),
                                                  ('책 읽기 시간 참여', 180),
                                                  ('학습 도구 정리', 130),
                                                  ('조용한 자습 시간 유지', 170),
                                                  ('교실 장식 도움', 140),
                                                  ('특별 발표 참여', 190),
                                                  ('학교 행사 자원봉사', 160);

-- 리워드 지급 내역 테이블
drop table if exists reward_give;
CREATE TABLE Reward_give (
                             `give_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                             `reward_id`	BIGINT	NOT NULL,
                             `give_date`	DATETIME	NULL,
                             `std_id`	BIGINT	NOT NULL,
                             `tch_id`	BIGINT	NOT NULL
);

INSERT INTO Reward_give (reward_id, give_date, std_id, tch_id) VALUES
                                                                   (1, '2024-01-02', 11, 1),
                                                                   (4, '2024-01-05', 19, 1),
                                                                   (4, '2024-01-03', 18, 1),
                                                                   (4, '2024-01-19', 7, 1),
                                                                   (4, '2024-01-11', 5, 1),
                                                                   (10, '2024-01-01', 9, 1),
                                                                   (3, '2024-01-05', 18, 1),
                                                                   (5, '2024-01-26', 6, 1),
                                                                   (2, '2024-01-22', 1, 1),
                                                                   (3, '2024-01-01', 12, 1),
                                                                   (4, '2024-01-19', 11, 1),
                                                                   (1, '2024-01-06', 9, 1),
                                                                   (1, '2024-01-05', 14, 1),
                                                                   (9, '2024-01-04', 3, 1),
                                                                   (8, '2024-01-15', 12, 1),
                                                                   (9, '2024-01-19', 4, 1),
                                                                   (8, '2024-01-17', 8, 1),
                                                                   (10, '2024-01-02', 17, 1),
                                                                   (5, '2024-01-15', 1, 1),
                                                                   (1, '2024-01-16', 13, 1);


-- 금융 퀴즈 테이블
drop table if exists quiz;
CREATE TABLE Quiz (
                      `quiz_ID`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                      `quiz_content`	VARCHAR(1000)	NULL,
                      `answer1`	VARCHAR(200)	NULL,
                      `answer2`	VARCHAR(200)	NULL,
                      `answer3`	VARCHAR(200)	NULL,
                      `answer4`	VARCHAR(200)	NULL,
                      `answer_num`	CHAR(1)	NULL,
                      `quiz_date`	DATETIME	NULL
);

INSERT INTO Quiz (quiz_content, answer1, answer2, answer3, answer4, answer_num, quiz_date) VALUES
                                                                                               ('은행에 돈을 맡기면 받을 수 있는 이자를 무엇이라고 할까요?', '이자', '수수료', '세금', '대출', '1', '2024-01-01'),
                                                                                               ('돈을 빌리고 나중에 갚는 것을 무엇이라고 하나요?', '저축', '대출', '투자', '기부', '2', '2024-01-02'),
                                                                                               ('돈을 모아두고 나중에 쓰는 것을 무엇이라고 할까요?', '대출', '저축', '기부', '수수료', '2', '2024-01-03'),
                                                                                               ('돈을 투자해서 수익을 얻는 것을 무엇이라고 하나요?', '은행', '투자', '주식', '대출', '2', '2024-01-04'),
                                                                                               ('은행에서 돈을 보관하는 방법을 무엇이라고 할까요?', '현금', '카드', '적금', '예금', '4', '2024-01-05'),
                                                                                               ('월급을 받아 생활비로 쓰는 것은 무엇이라고 하나요?', '저축', '대출', '세금', '수수료', '1', '2024-01-06'),
                                                                                               ('사람들이 돈을 모아서 기업에 투자하는 것을 무엇이라고 하나요?', '대출', '투자', '주식', '세금', '2', '2024-01-07'),
                                                                                               ('신용카드를 사용하면 나중에 어떤 것을 해야 하나요?', '지불', '저축', '저축', '대출', '1', '2024-01-08'),
                                                                                               ('돈을 빌릴 때 추가로 내는 비용을 무엇이라고 하나요?', '수수료', '이자', '세금', '대출', '2', '2024-01-09'),
                                                                                               ('돈을 어떻게 관리할지 미리 계획을 세우는 것을 무엇이라고 하나요?', '저축', '대출', '대출', '예산', '4', '2024-01-10');


-- 퀴즈왕 테이블
drop table if exists quiz_record;
CREATE TABLE Quiz_record (
                             `qr_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                             `quiz_ID`	BIGINT	NOT NULL,
                             `isCorrect`	CHAR(1)	NULL,
                             `std_id`	BIGINT	NOT NULL
);

INSERT INTO Quiz_record (quiz_ID, isCorrect, std_id) VALUES
                                                         (10, 'Y', 1),
                                                         (4, 'N', 7),
                                                         (3, 'N', 10),
                                                         (6, 'Y', 1),
                                                         (8, 'N', 6),
                                                         (3, 'N', 18),
                                                         (4, 'N', 3),
                                                         (7, 'Y', 14),
                                                         (1, 'N', 3),
                                                         (6, 'N', 19),
                                                         (7, 'N', 10),
                                                         (2, 'N', 1),
                                                         (6, 'Y', 20),
                                                         (8, 'N', 3),
                                                         (7, 'Y', 8),
                                                         (7, 'N', 17),
                                                         (2, 'N', 10),
                                                         (6, 'Y', 11),
                                                         (3, 'Y', 17),
                                                         (2, 'Y', 12),
                                                         (6, 'Y', 8),
                                                         (2, 'Y', 9),
                                                         (4, 'Y', 20),
                                                         (3, 'Y', 6),
                                                         (8, 'N', 19),
                                                         (10, 'N', 19),
                                                         (10, 'N', 11),
                                                         (3, 'N', 3),
                                                         (8, 'N', 10),
                                                         (5, 'Y', 12),
                                                         (9, 'Y', 10),
                                                         (8, 'N', 2),
                                                         (1, 'N', 10),
                                                         (2, 'Y', 20),
                                                         (10, 'N', 15),
                                                         (10, 'Y', 15),
                                                         (10, 'Y', 11),
                                                         (10, 'N', 17),
                                                         (3, 'Y', 15),
                                                         (2, 'N', 3),
                                                         (9, 'Y', 2),
                                                         (4, 'N', 15),
                                                         (9, 'Y', 12),
                                                         (6, 'N', 13),
                                                         (7, 'N', 20),
                                                         (1, 'N', 3),
                                                         (6, 'Y', 18),
                                                         (7, 'N', 9),
                                                         (10, 'Y', 11),
                                                         (2, 'Y', 12);


-- 선생님 테이블
drop table if exists teacher;
CREATE TABLE Teacher (
                         `tch_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                         `tch_name`	VARCHAR(30)	NULL,
                         `tch_email`	VARCHAR(100)	NULL,
                         `tch_account`	VARCHAR(100)	NULL,
                         `tch_pw`	VARCHAR(100)	NULL,
                         `grade`	INT	NULL,
                         `room`	VARCHAR(100)	NULL
);


INSERT INTO Teacher (tch_name, tch_email, tch_account, tch_pw, grade, room) VALUES
                                                                                ('김철수', 'kim@example.com', 'kimc', 'password123', 1, '1반'),
                                                                                ('이영희', 'lee@example.com', 'leey', 'qwerty456', 2, '2반'),
                                                                                ('박민수', 'park@example.com', 'parkm', 'abcde789', 3, '3반'),
                                                                                ('최정훈', 'choi@example.com', 'choij', 'securePass', 4, '4반'),
                                                                                ('정예진', 'jung@example.com', 'jungy', 'myPassword', 5, '5반');


-- 출석체크 테이블
drop table if exists daily_check;
CREATE TABLE Daily_check (
                             `check_id`	BIGINT PRIMARY KEY	NOT NULL AUTO_INCREMENT,
                             `std_id`	BIGINT	NOT NULL,
                             `tch_id`	BIGINT	NOT NULL,
                             `check_date`	DATETIME	NULL,
                             `isCheck`	CHAR(1)	NULL
);

INSERT INTO Daily_check (std_id, tch_id, check_date, isCheck) VALUES
                                                                  (14, 1, '2024-01-22', 'Y'),
                                                                  (16, 1, '2024-01-23', 'N'),
                                                                  (3, 1, '2024-01-29', 'Y'),
                                                                  (11, 1, '2024-01-20', 'Y'),
                                                                  (3, 1, '2024-01-05', 'N'),
                                                                  (20, 1, '2024-01-21', 'N'),
                                                                  (13, 1, '2024-01-20', 'N'),
                                                                  (15, 1, '2024-01-17', 'N'),
                                                                  (4, 1, '2024-01-26', 'Y'),
                                                                  (18, 1, '2024-01-24', 'Y'),
                                                                  (14, 1, '2024-01-15', 'Y'),
                                                                  (14, 1, '2024-01-11', 'N'),
                                                                  (13, 1, '2024-01-14', 'Y'),
                                                                  (11, 1, '2024-01-14', 'N'),
                                                                  (9, 1, '2024-01-12', 'Y'),
                                                                  (16, 1, '2024-01-03', 'Y'),
                                                                  (3, 1, '2024-01-03', 'N'),
                                                                  (4, 1, '2024-01-24', 'N'),
                                                                  (5, 1, '2024-01-18', 'Y'),
                                                                  (19, 1, '2024-01-31', 'N'),
                                                                  (4, 1, '2024-01-14', 'N'),
                                                                  (14, 1, '2024-01-28', 'Y'),
                                                                  (10, 1, '2024-01-20', 'N'),
                                                                  (12, 1, '2024-01-04', 'Y'),
                                                                  (5, 1, '2024-01-22', 'N'),
                                                                  (8, 1, '2024-01-28', 'Y'),
                                                                  (12, 1, '2024-01-28', 'N'),
                                                                  (4, 1, '2024-01-25', 'N'),
                                                                  (19, 1, '2024-01-08', 'N'),
                                                                  (18, 1, '2024-01-25', 'Y'),
                                                                  (20, 1, '2024-01-30', 'N'),
                                                                  (1, 1, '2024-01-06', 'N'),
                                                                  (10, 1, '2024-01-30', 'N'),
                                                                  (12, 1, '2024-01-01', 'Y'),
                                                                  (5, 1, '2024-01-19', 'N'),
                                                                  (3, 1, '2024-01-05', 'Y'),
                                                                  (3, 1, '2024-01-24', 'Y'),
                                                                  (13, 1, '2024-01-14', 'N'),
                                                                  (11, 1, '2024-01-06', 'N'),
                                                                  (10, 1, '2024-01-24', 'N'),
                                                                  (19, 1, '2024-01-20', 'Y'),
                                                                  (2, 1, '2024-01-05', 'Y'),
                                                                  (20, 1, '2024-01-02', 'Y'),
                                                                  (9, 1, '2024-01-15', 'N'),
                                                                  (16, 1, '2024-01-20', 'N'),
                                                                  (14, 1, '2024-01-09', 'Y'),
                                                                  (17, 1, '2024-01-04', 'N'),
                                                                  (14, 1, '2024-01-04', 'N'),
                                                                  (19, 1, '2024-01-16', 'N'),
                                                                  (2, 1, '2024-01-08', 'N');

