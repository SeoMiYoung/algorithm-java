from itertools import permutations

def solution(k, dungeons):
    max_count = 0
    
    for p in permutations(dungeons, len(dungeons)): 
        # 반환값: 이터레이터(튜플, 튜플, 튜플, ...)
        # p: ([80,20],[50,40],[30,10])
        count = 0
        cur_power = k
        
        for dungeon in p:
            if cur_power >= dungeon[0]:
                count += 1
                cur_power -= dungeon[1]
            else:
                break
     
        
        if max_count < count:
            max_count = count
    
    return max_count


# 음 그러면, 순열이네?
# 다음 호출로 넘겨줘야하는 것이 dfs의 인자로 들어간다
# 생각을 해보면, 남은 피로도와 

