def solution(nums):
    max_case = len(nums) // 2
    min_case = len(set(nums))
    return min(max_case, min_case)





# 최대 경우의 수: nums//2
# 최소 경우의 수:
## 만약에 종류가 nums//2만큼 있으면 무조건 nums//2만큼임
## 근데 종료가 nums//2보다 작으면, 그냥 그만큼임

