--001. 전제 축구팀 목록을 팀이름 오름차순으로 출력하시오
select team_name,region_name  from team order by team_name asc;
-- 002. 플레이어 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈 공간으로 두시오
SELECT DISTINCT POSITION from player;
--003. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입'으로 기재하시오
-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.
SELECT player.player_name
FROM player
WHERE team_id IN (SELECT team_id
               FROM team
               WHERE team_name = '삼성블루윙즈' OR '드래곤즈')
    AND  POSITION = 'MF' AND height >= 170 AND height <=180;
-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
select player.player_name
FROM player
where team_id=(select team_id
               FROM team
               WHERE region_name = '수원') and POSITION = 'GK';
-- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오-- 키와 몸무게가 없으면 "0" 으로 표시하시오-- 키와 몸무게는 내림차순으로 정렬하시오
SELECT player.player_name,IFNULL(NULLIF(player.height,''),0), IFNULL(NULLIF(player.weight,''),0)
FROM player ORDER BY player.height DESC ,weight DESC ;
-- 문제 9-- 서울팀 선수들 이름과 포지션과-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오-- 단, 키와 몸무게가 없으면 "0" 표시하시오-- BMI는 "NONE" 으로 표시하시오(as bmi)-- 최종 결과는 이름내림차순으로 정렬하시오
SELECT player.player_name,IFNULL(NULLIF(CONCAT(player.height,'CM'),'CM'),'0') height
     ,IFNULL(NULLIF(CONCAT(player.weight,'KG'),'KG'),0) weight,IFNULL(height/((player.weight*player.weight)*100),"NONE")AS BMI
FROM player ORDER BY player.height desc , weight desc ;
WHERE team_id=(select team_id
               FROM team
               WHERE team_name = 'FC서울');