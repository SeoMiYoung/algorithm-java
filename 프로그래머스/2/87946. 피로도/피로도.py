def solution(k, dungeons):
    visited = [0] * len(dungeons) # [0,0,0]
    max_count = 0
    
    def dfs(remaining_power, v_count):
        # 이 함수 안에서 max_count라는 이름을 쓸 건데, 그건 새로 만드는 게 아니라 바깥 함수 걸 가져다 쓰는 거야~
        nonlocal max_count
        
        # 빠져나오는 처리
        if max_count < v_count:
            max_count = v_count
            
        
        # 재귀 호출
        for i in range(0, len(dungeons)):
            if (visited[i] == 0) and (remaining_power >= dungeons[i][0]): # 아직 방문 전
                visited[i] = 1 # 방문 처리
                dfs(remaining_power - dungeons[i][1], v_count+1)
                visited[i] = 0 # 미방문 처리
            
                    
    
    dfs(k, 0)  # 아직 하나도 방문 안함
    return max_count


# 음 그러면, 순열이네?
# 다음 호출로 넘겨줘야하는 것이 dfs의 인자로 들어간다
# 생각을 해보면, 남은 피로도와 

