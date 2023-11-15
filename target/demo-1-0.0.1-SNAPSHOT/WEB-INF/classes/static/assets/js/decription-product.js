function showTab(tabId) {
      const tabs = document.querySelectorAll('.tab-content');
      tabs.forEach(tab => {
        tab.style.display = 'none';
      });

      const tabToShow = document.getElementById(tabId);
      if (tabToShow) {
        tabToShow.style.display = 'block';
      }
    }