package com.wangyue.service.Impl;

import com.wangyue.domain.Music;
import com.wangyue.mapper.MusicMapper;
import com.wangyue.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;
    @Override
    public List<Music> findAll() {
        return musicMapper.findAll();
    }
}
