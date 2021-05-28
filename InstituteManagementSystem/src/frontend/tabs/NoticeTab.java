package frontend.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import classes.Notice;
import frontend.Main;

public class NoticeTab {
	
	// Notice
	public JPanel viewnotice;
	
	private JTextPane noticePane;
	private JLabel titlePane;
	private JList<Notice> noticeList;
	private DefaultListModel<Notice> listModel;
	
	private JButton prevButton, nextButton, deleteButton;
	private ArrayList<Notice> notices;
	private int currentIdx = 0;
	private boolean isAdmin;
		
	public NoticeTab(boolean isAdmin) {
		this.isAdmin = isAdmin;
		this.noticePane();
	}
	
	public void noticePane() {
		
		viewnotice = new JPanel();
		
		JLabel noticeListLabel = new JLabel("Notice List");
		noticeListLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		noticeListLabel.setBounds(60, 66, 200, 35);
		viewnotice.add(noticeListLabel);
		
		titlePane = new JLabel();
		titlePane.setFont(new Font("Dialog", Font.BOLD, 24));
		titlePane.setBounds(568, 66, 700, 30);
		viewnotice.add(titlePane);
		
		noticePane = new JTextPane();
		noticePane.setEditable(false);
		noticePane.setFont(new Font("Calibri", Font.PLAIN, 20));
		noticePane.setBounds(568, 100, 700, 400);
		viewnotice.add(noticePane);
				

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 120, 435, 323);
		viewnotice.add(scrollPane);
		
		listModel = new DefaultListModel<>();
		reload();
		for(Notice n: notices) {
			listModel.addElement(n);
		}
		
		noticeList = new JList<Notice>(listModel);
		noticeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		noticeList.setFont(new Font("Calibri", Font.PLAIN, 16));
		noticeList.setCellRenderer(new CustomCellRenderer());
		scrollPane.setViewportView(noticeList);
		
		reload();
		update();

		noticeList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int idx = noticeList.getSelectedIndex();
				if (idx != -1) {
					Notice notice = notices.get(idx);
					noticePane.setText(notice.content);
					titlePane.setText(notice.title);
					currentIdx = idx;
				}
				update();
			}
		});
		
		if (this.isAdmin) {
			prevButton = new JButton(" < Previous");
			prevButton.setFont(new Font("Calibri", Font.BOLD, 20));
			prevButton.setBounds(568, 593, 157, 44);
			viewnotice.add(prevButton);
			
			nextButton = new JButton("Next >");
			nextButton.setFont(new Font("Calibri", Font.BOLD, 20));
			nextButton.setBounds(1103, 593, 157, 44);
			viewnotice.add(nextButton);
			
			deleteButton = new JButton("Delete");
			deleteButton.setFont(new Font("Calibri", Font.BOLD, 20));
			deleteButton.setBounds(835, 593, 157, 44);
			viewnotice.add(deleteButton);
			
			prevButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					System.out.println(currentIdx);
					if (currentIdx > 0) {
						currentIdx--;
					}
					update();
				}
			});
			nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					System.out.println(currentIdx);
//					System.out.println(notices.size());
					if (currentIdx < notices.size()-1) {
						currentIdx++;
					}
					update();
					if (notices.size() > 0) {
						noticePane.setText(notices.get(currentIdx).content);
						titlePane.setText(notices.get(currentIdx).title);
					}
//					System.out.println(currentIdx);
				}
			});
			deleteButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Notice curr = notices.get(currentIdx);
					curr.delete(Main.db);
					notices.remove(currentIdx);
					int deleteIdx = currentIdx;
					while (currentIdx >= notices.size()) {
						currentIdx--;
					}
					
					System.out.println("CURRENT " + currentIdx);
					System.out.println("SIZE " + notices.size());
					
//					reload();
					try {
						listModel.remove(deleteIdx);
					} catch (NullPointerException exception) {
						System.out.println("Error while deleting notice " + curr.getId());
					}
					
					update();
					noticeList.setModel(listModel);
				}
			});
		}
	}
	
	private void reload() {
		notices = Notice.getNotices(Main.db);
		currentIdx = 0;
	}
	
	private void update() {
		if (notices.size() > 0) {
			noticePane.setText(notices.get(currentIdx).content);
			titlePane.setText(notices.get(currentIdx).title);
			noticeList.setSelectedIndex(currentIdx);
		} else {
			noticePane.setText("");
			titlePane.setText("");
			noticeList.setSelectedIndex(-1);
		}
	}
	
	public void updateNotices() {
		reload();
		
		listModel = new DefaultListModel<>();
		for(Notice n: notices) {
			listModel.addElement(n);
		}
		update();
		
		noticeList.setModel(listModel);
	}
}

class CustomCellRenderer extends JLabel implements ListCellRenderer<Notice>{
	
	private static final long serialVersionUID = -3244403501084845080L;
	CustomCellRenderer(){
		super();
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends Notice> list, Notice value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(value.publishDate);
		JLabel name = new JLabel(String.format("%s (%d/%d/%d)", value.title, cal.get(Calendar.DATE), cal.get(Calendar.MONTH), cal.get(Calendar.YEAR)));
		name.setFont(new Font("Calibri", Font.PLAIN, 16));
		name.setOpaque(true);
		
		name.setBorder(BorderFactory.createEmptyBorder(10, 2, 10, 2));

        // check if this cell represents the current DnD drop location
        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

//            name.setBackground(Color.black);
//            name.setForeground(Color.white);

        // check if this cell is selected
        } else if (isSelected) {
        	 name.setBackground(Color.GRAY);
//             name.setFont(new Font("Calibri", Font.BOLD, 16));
//             name.setBorder(BorderFactory.createLineBorder(Color.BLUE));
             name.setForeground(Color.white);
             

        // unselected, and not the DnD drop location
        } else {
        	 name.setBackground(Color.white);
             name.setForeground(Color.black);
        };
		
		return name;
	}
	
}

