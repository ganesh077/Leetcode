select LEAST(from_id,to_id) as person1,GREATEST(from_id,to_id) as person2,
 count(*) as call_count ,
    sum(duration) as total_duration
from Calls
group by LEAST(from_id,to_id),GREATEST(from_id,to_id)