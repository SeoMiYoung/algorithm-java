# 없는 한 명을 찾으면 됨
# 해시는 사물함이다. 사물함 문에 이름표가 붙어 있어서, "mislav" 사물함을 찾을 때 1번부터 열어보는 게 아니라 이름표 보고 바로 열 수 있음
# 이것이 해시의 특징임
# 키(이름)로 값을 찾는 데 명단 길이와 상관없이 거의 한 번에 찾음
# 동명이인이 있을 수 있으니 해시로

def solution(participant, completion):
    count = {}  # 빈 딕셔너리 (빈 사물함들)
    
    # 참가자 이름별로 +1
    for p_name in participant:
        current_cnt = count.get(p_name, 0); # 없으면 0으로
        count[p_name] = current_cnt + 1;
    # print(count);
    
    # [결과] {'미영': 2, '수빈': 1, '유진': 3} 이런 형태
        
    # 이제 완주한 사람들도 뺄거임
    for c_name in completion:
        count[c_name] = (count[c_name] - 1);
        
    # 0이 아닌 사람이 문제인겨
    for check in count:
        if (count.get(check) != 0):
            return check
    
