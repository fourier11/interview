# 贪婪算法，求的是近似值
# You pass an array in, and it gets converted to a set.
states_needed = set(["mt", "wa", "or", "id", "nv", "ut", "ca", "az"])

stations = {}
stations["kone"] = set(["id", "nv", "ut"])
stations["ktwo"] = set(["wa", "id", "mt"])
stations["kthree"] = set(["or", "nv", "ca"])
stations["kfour"] = set(["nv", "ut"])
stations["kfive"] = set(["ca", "az"])
# 用于存储最终选择的广播台
final_stations = set()

while states_needed:
  best_station = None
  # states_covered 包含该广播台覆盖的所有未覆盖的州
  states_covered = set()
  for station, states in stations.items():
    covered = states_needed & states
    if len(covered) > len(states_covered):
      best_station = station
      states_covered = covered
  # 更新 states_needed，由于该广播台覆盖了一些州，不需要再次覆盖
  states_needed -= states_covered
  final_stations.add(best_station)

print(final_stations)
