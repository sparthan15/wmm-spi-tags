package com.wmm.api.tags.infrastructure.adapters.model.response;

import com.wmm.api.tags.domain.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TagResponse {
    private  String id;
    private  String name;
    private  String description;
    private  Double amounnt;
    private  String period;
    private  String userId;

   public TagResponse(Tag tag){
       this.id = tag.getId();
       this.amounnt = tag.getThresholdLimit().getMaxExpense();
       this.userId = tag.getUserId();
       this.name = tag.getName();
       this.description = tag.getDescription();
       this.period = tag.getThresholdLimit().getThresholdPeriodName();
       this.amounnt = tag.getThresholdLimit().getMaxExpense();
   }

    public TagResponse mapFromModel(Tag tag){
        this.id = tag.getId();
        this.amounnt = tag.getThresholdLimit().getMaxExpense();
        this.userId = tag.getUserId();
        this.name = tag.getName();
        this.description = tag.getDescription();
        this.period = tag.getThresholdLimit().getThresholdPeriodName();
        this.amounnt = tag.getThresholdLimit().getMaxExpense();
        return this;
    }
}
