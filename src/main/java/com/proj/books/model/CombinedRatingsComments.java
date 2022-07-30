package com.proj.books.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CombinedRatingsComments {
    private Comment comment;
    private Ratings rating;
}
