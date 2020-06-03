package org.rhb.vhr.utils;

import org.rhb.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;


public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
