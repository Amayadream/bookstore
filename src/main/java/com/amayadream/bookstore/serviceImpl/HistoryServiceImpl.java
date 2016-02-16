package com.amayadream.bookstore.serviceImpl;

import com.amayadream.bookstore.dao.IHistoryDao;
import com.amayadream.bookstore.pojo.History;
import com.amayadream.bookstore.service.IHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.02.16 21:32
 */
@Service(value = "historyService")
public class HistoryServiceImpl implements IHistoryService {

    @Resource private IHistoryDao historyDao;

    public List<History> selectByUserid(int page, int pageSize, String userid) {
        int start = 1;
        int end = pageSize;
        if(page != 1) {
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return historyDao.selectByUserid(start, end, userid);
    }

    public History selectById(String id) {
        return historyDao.selectById(id);
    }

    public History selectByBookid(String userid, String bookid) {
        return historyDao.selectByBookid(userid, bookid);
    }

    public boolean insert(History history) {
        return historyDao.selectByBookid(history.getUserid(), history.getBookid())==null && historyDao.insert(history);
    }

    public boolean update(History history) {
        if(historyDao.selectByBookid(history.getUserid(), history.getBookid()) == null){
            historyDao.insert(history);
            return true;
        }
        return historyDao.update(history);
    }

    public boolean delete(String id) {
        return historyDao.selectById(id)!=null && historyDao.delete(id);
    }

    public boolean deleteByBook(String userid, String bookid) {
        return historyDao.selectByBookid(userid, bookid)!=null && historyDao.deleteByBook(userid, bookid);
    }
}
