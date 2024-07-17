with scores_cte as (
select host_team, 
    guest_team, 
    case 
        when host_goals > guest_goals
        then 3
        when host_goals = guest_goals
        then 1 else 0
        end as host_points,
       case when host_goals < guest_goals
        then 3
        when host_goals = guest_goals
        then 1 else 0
        end as guest_points
from Matches
),
host_scores as (
    select team_id,t.team_name as team,
        sum(h.host_points) as scores
    from Teams t left join
    scores_cte h on h.host_team = t.team_id
    group by t.team_name  
),
guest_scores as (
    select team_id,t.team_name as team,
        sum(h.guest_points) as scores
    from Teams t left join
    scores_cte h on h.guest_team = t.team_id
    group by t.team_name  
),
combines_cte as (
select team_id,team,
    coalesce(scores,0) as scores
from host_scores
union all
select team_id,team,
    coalesce(scores,0) as scores
from guest_scores
)
select team_id,team as team_name,
    sum(scores) as num_points
from combines_cte
group by team_id,team
order by num_points desc,team_id